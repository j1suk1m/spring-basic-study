package study.spring.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountAmount;

    public int calculatePrice() {
        return itemPrice - discountAmount;
    }
}
