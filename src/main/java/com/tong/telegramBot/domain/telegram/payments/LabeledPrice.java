package com.tong.telegramBot.domain.telegram.payments;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This object represents a portion of the price for goods or services.
 * <p>
 * Created by tong on 2022/08/24
 */
@Data
@Accessors(chain = true)
public class LabeledPrice {

    private String label; // Portion label
    private Integer amount; // Price of the product in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).

}
