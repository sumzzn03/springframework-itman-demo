package ioccontainer;


import ioccontainer.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className BookManagerService
 * @description
 * @JunitTest: {@link  }
 * @date 2020-05-06 21:58
 **/
public class BookManagerService implements IBookManagerService {

    /*** 属性注入 */
//    @Autowired
    private IBookService bookService;


    @Autowired
    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void save(Book book) {
        bookService.save(book);
    }

    @Override
    public void update(Book book) {
        bookService.update(book);
    }
}
