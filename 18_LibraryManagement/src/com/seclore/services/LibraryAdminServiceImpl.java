package com.seclore.services;

import com.seclore.dao.LibraryAdminDaoImpl;
import com.seclore.interfaces.LibraryAdminDao;
import com.seclore.interfaces.LibraryAdminService;
import com.seclore.pojo.Book;
import com.seclore.pojo.Member;

public class LibraryAdminServiceImpl implements LibraryAdminService{
	LibraryAdminDao libraryAdminDao;
	public LibraryAdminServiceImpl()
	{
		this.libraryAdminDao= new LibraryAdminDaoImpl();
	}
	
	@Override
	public boolean addBook(Book book)
	{
		return libraryAdminDao.addBook(book);
	}
	@Override
	public boolean deleteBook(String book_id)
	{
		return libraryAdminDao.deleteBook(book_id);
	}
	@Override
	public boolean updateBook(Book book)
	{
		return libraryAdminDao.updateBook(book);
	}
	@Override
	public boolean addMember(Member member)
	{
		return libraryAdminDao.addMember(member);
	}
	@Override
	public boolean deleteMember(String member_id)
	{
		return libraryAdminDao.deleteMember(member_id);
	}
	@Override
	public boolean updateMember(Member member)
	{
		return libraryAdminDao.updateMember(member);
	}

}
