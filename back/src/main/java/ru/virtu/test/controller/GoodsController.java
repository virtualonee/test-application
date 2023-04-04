package ru.virtu.test.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.virtu.test.dto.GoodsDTO;
import ru.virtu.test.models.Goods;
import ru.virtu.test.services.GoodsService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/goods")
@CrossOrigin(origins = "http://localhost:4200")
public class GoodsController {

    private final GoodsService goodsService;
    private final ModelMapper modelMapper;

    @Autowired
    public GoodsController(GoodsService goodsService, ModelMapper modelMapper) {
        this.goodsService = goodsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<GoodsDTO> getAllGoodses() {
        return convertToGoodsDTOList(goodsService.findAll());
    }

    @GetMapping("/{id}/get")
    public GoodsDTO getGoods(@PathVariable Long id){
        return convertToGoodsDTO(goodsService.findOne(id));
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addGoods(@RequestBody @Valid GoodsDTO goodsDTO){

        Goods goods = convertToGoods(goodsDTO);
        goodsService.save(goods);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<HttpStatus> updateGoods(@PathVariable Long id, @RequestBody @Valid GoodsDTO goodsDTO){

        Goods goods = convertToGoods(goodsDTO);
        goodsService.update(id, goods);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity <HttpStatus> deleteGoods(@PathVariable Long id) {
        goodsService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public Goods convertToGoods(GoodsDTO goodsDTO){
        return modelMapper.map(goodsDTO, Goods.class);
    }

    private GoodsDTO convertToGoodsDTO(Goods goods) {
        return modelMapper.map(goods, GoodsDTO.class);
    }

    private List<GoodsDTO> convertToGoodsDTOList(List<Goods> goodses){
        List<GoodsDTO> goodsesDTO = new ArrayList<>();

        for (Goods goods:
             goodses) {
            goodsesDTO.add(convertToGoodsDTO(goods));
        }

        return goodsesDTO;
    }

}
