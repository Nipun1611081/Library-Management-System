package com.seclore.interfaces;

import com.seclore.pojo.Book;
import com.seclore.pojo.Member;

public interface LibraryAdminService {
	public boolean addBook(Book book);
	public boolean deleteBook(String book_id);
	public boolean updateBook(Book book);
	public boolean addMember(Member member);
	public boolean deleteMember(String member_id);
	public boolean updateMember(Member member);
}
