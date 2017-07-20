import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import com.softserve.edu.webproject.entity.Order;
import com.softserve.edu.webproject.model.OrderInfo;
import com.softserve.edu.webproject.repository.OrderDetailRepository;
import com.softserve.edu.webproject.repository.OrderRepository;
import com.softserve.edu.webproject.repository.ProductRepository;
import com.softserve.edu.webproject.service.OrderService;
import com.softserve.edu.webproject.service.impl.OrderServiceImpl;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderServiceTest {

  @Mock
  private OrderRepository orderRep;
  @Mock
  private OrderDetailRepository orderDetailRep;
  @Mock
  private ProductRepository productRep;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getOrderInfoByOrderId() {

    OrderService service = new OrderServiceImpl(orderRep, productRep, orderDetailRep);
    Order order = new Order();
    order.setId("1");
    order.setOrderDate(new Date());
    order.setOrderNum(7);
    order.setAmount(100);
    order.setCustomerName("Customer");

    when(orderRep.findOne(anyString())).thenReturn(order);

    OrderInfo orderInfo = service.getOrderInfoByOrderId(anyString());

    assertEquals(order.getAmount(),orderInfo.getAmount(),0.0001);
    assertEquals(order.getCustomerName(),orderInfo.getCustomerName());
    assertEquals(order.getOrderNum(),orderInfo.getOrderNum());
    assertEquals(order.getOrderDate(),orderInfo.getOrderDate());
  }

}
