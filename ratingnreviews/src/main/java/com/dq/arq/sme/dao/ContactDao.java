/**
 * 
 */
package com.dq.arq.sme.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dq.arq.sme.domain.ContactDo;

/**
 * @author prabhakar
 *
 */
public interface ContactDao {
//	public ContactDo getContactDoByEmailIdAndPassword(ContactDo contactDo);

	public ContactDo getContactDoById(Integer id);

	public List<ContactDo> getOtherUsers(Integer id);

	public ContactDo addUser(ContactDo contactDo);

	ContactDo processRow(ResultSet rs) throws SQLException;

	public List<ContactDo> getAllUsers();

	public Integer saveContact(ContactDo userDo);

	public void updateContact(ContactDo userDo);

	public void deleteContact(ContactDo userDo);

	public void savePhoto(InputStream uploadedInputStream);
	
	public InputStream fileDownload(Integer id);

	public ContactDo getContactDoByUsernameAndPassword(String username, String password);
}
