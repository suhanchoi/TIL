package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    // 상품 저장
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    // 상품 업데이트 // 커맨드와 쿼리 나눔
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = itemRepository.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    // 전체 조회
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    // 한개 조회
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
