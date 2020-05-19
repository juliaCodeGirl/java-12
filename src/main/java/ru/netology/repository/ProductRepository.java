package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Product;

@NoArgsConstructor
@AllArgsConstructor
public class ProductRepository {
    private Product[]items = new Product[0];

    public Product[] findAll() {
        return items;
    }

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[items.length - 1];
        int i = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[i] = item;
                i++;
            }
        }
        items =tmp;
    }

}