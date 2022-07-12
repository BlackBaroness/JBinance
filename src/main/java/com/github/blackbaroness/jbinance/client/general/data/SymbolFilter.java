package com.github.blackbaroness.jbinance.client.general.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolFilter {

    // PRICE_FILTER

    FilterType filterType;

    /**
     * Defines the minimum price/stopPrice allowed.
     */
    String minPrice;

    /**
     * Defines the maximum price/stopPrice allowed.
     */
    String maxPrice;

    /**
     * Defines the intervals that a price/stopPrice can be increased/decreased by.
     */
    String tickSize;


    // LOT_SIZE

    /**
     * Defines the minimum quantity/icebergQty allowed.
     */
    String minQty;

    /**
     * Defines the maximum quantity/icebergQty allowed.
     */
    String maxQty;

    /**
     * Defines the intervals that a quantity/icebergQty can be increased/decreased by.
     */
    String stepSize;

    // MIN_NOTIONAL

    /**
     * Defines the minimum notional value allowed for an order on a symbol. An order's notional value is the price * quantity.
     */
    String minNotional;


    // MAX_NUM_ALGO_ORDERS

    /**
     * Defines the maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, and TAKE_PROFIT_LIMIT orders.
     */
    String maxNumAlgoOrders;

    /**
     * MAX_NUM_ORDERS filter defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders and normal orders are counted for this filter.
     * MAX_ALGO_ORDERS filter defines the maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, and TAKE_PROFIT_LIMIT orders.
     * ICEBERG_PARTS filter defines the maximum parts an iceberg order can have. The number of ICEBERG_PARTS is defined as CEIL(qty / icebergQty).
     */
    String limit;
}
