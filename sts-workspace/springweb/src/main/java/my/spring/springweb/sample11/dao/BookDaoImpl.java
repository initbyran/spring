	package my.spring.springweb.sample11.dao;

	import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.spring.springweb.sample11.vo.Book;


	@Repository
	public class BookDaoImpl implements BookDao{
	   
	   @Autowired
	   SqlSession session;
	   // SqlSession은 interface임
	   
	   @Override
	   public int getBookCount() {
	      
	      return session.selectOne("myBook.countBooks");
	   }
	   
	   @Override
	   public List<Book> getAllBooks() {
	      
	      return session.selectList("myBook.selectAll");
	   }
	   
	   
	  @Override
		public List<Book> getSearchBooks(String keyword) {
		
		  return session.selectList("myBook.selectBookByKeyword", keyword);
		}
	}
	