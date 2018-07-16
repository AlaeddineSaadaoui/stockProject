package com.dev.stocks;

import com.dev.stocks.controller.StockController;
import com.dev.stocks.model.StockStats;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.core.Is.is;


@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
@ContextConfiguration(classes=com.dev.stocks.StocksApplication.class)

public class StocksApplicationTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StockController stockController;


    @Test
    public void contextLoads() {
    }

    @Test
    public void dataLoad() throws Exception {
        mvc.perform(post("/load")).andExpect(status().isOk());
    }
  /*  @Test
    public void getStockStatsByDate() throws Exception{
        StockStats stockStats=new StockStats(1120.01,1130.99,new Long(724223),"2018-06-22T16:30:00.000+0000");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        given(stockController.getDataByDate("GOOG","2018-06-22")).willReturn(mapper.writeValueAsString(stockStats));
        mvc.perform(get("/{stockName}/{inputDate}","GOOG","2018-06-22")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("StockStats.lowest_price", is(stockStats.getLowestPrice())))
        .andExpect(jsonPath("StockStats.highest_price", is(stockStats.getHighestPrice())))
        .andExpect(jsonPath("StockStats.total_volume", is(stockStats.getTotalVolume().intValue())))
        .andExpect(jsonPath("StockStats.closing_date", is(stockStats.getClosingDate())));
    }
    @Test
    public void getStockStatsByMonth() throws Exception{
        StockStats stockStats=new StockStats((double)1120,1130.99,new Long(2159363),"2018-06-26T16:30:00.000+0000");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        given(stockController.getDataByDate("GOOG","2018-06")).willReturn(mapper.writeValueAsString(stockStats));
        mvc.perform(get("/{stockName}/{inputDate}","GOOG","2018-06")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("StockStats.lowest_price", is(stockStats.getLowestPrice())))
                .andExpect(jsonPath("StockStats.highest_price", is(stockStats.getHighestPrice())))
                .andExpect(jsonPath("StockStats.total_volume", is(stockStats.getTotalVolume().intValue())))
                .andExpect(jsonPath("StockStats.closing_date", is(stockStats.getClosingDate())));
    }*/

}