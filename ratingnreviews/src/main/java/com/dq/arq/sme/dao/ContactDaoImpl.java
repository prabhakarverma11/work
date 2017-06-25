/**
 * 
 */
package com.dq.arq.sme.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dq.arq.sme.domain.ContactDo;

/**
 * @author prabhakar
 *
 */
@Repository
@Transactional
public class ContactDaoImpl implements ContactDao {
	@Autowired
	SessionFactory sessionFactory;
	public ContactDo getContactDoByUsernameAndPassword(String username,String password) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ContactDo.class)
				.add(Restrictions.eq("emailId", username).ignoreCase())
				.add(Restrictions.eq("password", password));
		
		List<ContactDo> contactDos = criteria.list();
		if(contactDos.size()>0)
			return contactDos.get(0);
		else
			return null;
	}

	public ContactDo getContactDoById(Integer id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		ContactDo dbContactDo = null;
//		Connection c = null;
//		try {
//			c = ConnectionHelper.getConnection();
//			PreparedStatement ps = c.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				dbContactDo = processRow(rs);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			ConnectionHelper.close(c);
//		}
		return dbContactDo;
	}

	public List<ContactDo> getOtherUsers(Integer id) {
		List<ContactDo> list = new ArrayList<ContactDo>();
//		Connection c = null;
//		String sql = "SELECT * FROM user WHERE id != ? ORDER BY name";
//		try {
//			c = ConnectionHelper.getConnection();
//			PreparedStatement ps = c.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				list.add(processRow(rs));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			ConnectionHelper.close(c);
//		}
		return list;
	}

	public ContactDo addUser(ContactDo contactDo) {
//		Connection c = null;
//		PreparedStatement ps = null;
//		try {
//			c = ConnectionHelper.getConnection();
//			ps = c.prepareStatement(
//					"INSERT INTO user (name, email_id,password, phone_number,is_logged_in) VALUES ( ?,?, ?, ?,?)",
//					new String[] { "ID" });
//			ps.setString(1, userDo.getName());
//			ps.setString(2, userDo.getEmailId());
//			ps.setString(3, userDo.getPassword());
//			ps.setString(4, userDo.getPhoneNumber());
//			ps.setBoolean(5, userDo.isLoggedIn());
//			ps.executeUpdate();
//			ResultSet rs = ps.getGeneratedKeys();
//			rs.next();
//			// Update the id in the returned object. This is important as this
//			// value must be returned to the client.
//			int id = rs.getInt(1);
//			userDo.setId(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			ConnectionHelper.close(c);
//		}
		return contactDo;
	}

	public ContactDo processRow(ResultSet rs) throws SQLException {
		ContactDo userDo = new ContactDo();
//		userDo.setId(rs.getInt("id"));
//		userDo.setName(rs.getString("name"));
//		userDo.setEmailId(rs.getString("email_id"));
//		userDo.setPhoneNumber(rs.getString("phone_number"));
		return userDo;
	}

	public List<ContactDo> getAllUsers() {
		String sql = "SELECT * FROM user";
		List<ContactDo> userDos = new ArrayList<ContactDo>();
//		Connection c = null;
//		try {
//			c = ConnectionHelper.getConnection();
//			PreparedStatement ps = c.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				userDos.add(processRow(rs));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			ConnectionHelper.close(c);
//		}
		return userDos;
	}

	public Integer saveContact(ContactDo contactDo) {
		sessionFactory.getCurrentSession().save(contactDo);
		return contactDo.getId();
	}

	public void updateContact(ContactDo userDo) {
//		Connection c = null;
//		PreparedStatement ps = null;
//		try {
//			c = ConnectionHelper.getConnection();
//			ps = c.prepareStatement("UPDATE user SET name=?,email_id=?,phone_number=? WHERE id=" + userDo.getId(),
//					new String[] { "ID" });
//			ps.setString(1, userDo.getName());
//			ps.setString(2, userDo.getEmailId());
//			ps.setString(3, userDo.getPhoneNumber());
//			ps.executeUpdate();
//			ResultSet rs = ps.getGeneratedKeys();
//			// Update the id in the returned object. This is important as this
//			// value must be returned to the client.
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			ConnectionHelper.close(c);
//		}
	}

	public void deleteContact(ContactDo userDo) {
//		Connection c = null;
//		PreparedStatement ps = null;
//		try {
//			c = ConnectionHelper.getConnection();
//			ps = c.prepareStatement("DELETE FROM user WHERE id=" + userDo.getId());
//			ps.executeUpdate();
//			// ResultSet rs = ps.getGeneratedKeys();
//			// Update the id in the returned object. This is important as this
//			// value must be returned to the client.
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			ConnectionHelper.close(c);
//		}
	}

	public void savePhoto(InputStream uploadedInputStream) {
//		Connection c = null;
//		PreparedStatement ps = null;
//		try {
//			c = ConnectionHelper.getConnection();
//			String sql = "INSERT INTO user (photo) values (?)";
//			ps = c.prepareStatement(sql);
//			ps.setBlob(1, uploadedInputStream);
//			ps.executeUpdate();
//			// ResultSet rs = ps.getGeneratedKeys();
//			// Update the id in the returned object. This is important as this
//			// value must be returned to the client.
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			ConnectionHelper.close(c);
//		}
	}

	public InputStream fileDownload(Integer id) {
		String sql = "SELECT photo FROM user WHERE id = ?";
		ContactDo dbContactDo = null;
		//Connection c = null;
		InputStream inputStream = null;
//		try {
//			c = ConnectionHelper.getConnection();
//			PreparedStatement ps = c.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				Blob blob = rs.getBlob("photo");
//				inputStream = blob.getBinaryStream();
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		} finally {
//			ConnectionHelper.close(c);
//		}
		return inputStream;
	}
}
