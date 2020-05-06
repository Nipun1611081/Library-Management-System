package com.seclore.services;

import com.seclore.dao.LibraryManagerDaoImpl;
import com.seclore.interfaces.LibraryManagerDao;
import com.seclore.interfaces.LibraryManagerService;
import com.seclore.pojo.Book;
import com.seclore.pojo.Member;
import com.seclore.pojo.Order;

public class LibraryManagerServiceImpl implements LibraryManagerService{
	LibraryManagerDao libraryManagerDao;
	
	public LibraryManagerServiceImpl()
	{
		this.libraryManagerDao= new LibraryManagerDaoImpl();
	}
	@Override
	public Member getMember (String member_code)
	{
		return libraryManagerDao.getMember(member_code);
	}
	@Override
	public Book getBook (String book_id)
	{
		return libraryManagerDao.getBook(book_id);
	}
	@Override
	public Order getOrder (int order_id)
	{
		return libraryManagerDao.getOrder(order_id);
	}
	@Override
	public boolean issueBook(Order order)
	{
		return libraryManagerDao.issueBook(order);
	}
	@Override
	public boolean returnBook(int order_id)
	{
		return libraryManagerDao.returnBook(order_id);
	}
	@Override
	public boolean deleteBook(int order_id)
	{
		return libraryManagerDao.deleteBook(order_id);
	}
	@Override
	public void showOrder_id()
	{
		libraryManagerDao.showOrder_id();
	}
	@Override
	public void getRecord()
	{
		libraryManagerDao.getRecord();
	}


}
