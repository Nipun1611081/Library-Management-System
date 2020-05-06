package com.seclore.interfaces;

import com.seclore.pojo.Book;
import com.seclore.pojo.Member;
import com.seclore.pojo.Order;

public interface LibraryManagerDao {
	public Member getMember (String member_code);
	public Book getBook (String book_id);
	public Order getOrder (int order_id);
	public boolean issueBook(Order order);
	public boolean returnBook(int order_id);
	public boolean deleteBook(int order_id);
	public void showOrder_id();
	public void getRecord ();
}
