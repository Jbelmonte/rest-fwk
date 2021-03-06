package org.company.techtest.business.impl;

import java.util.List;

import org.company.techtest.business.UsersBO;
import org.company.techtest.dao.UserDAO;
import org.company.techtest.model.User;
import org.restberrypi.core.dao.exceptions.NotFoundException;
import org.restberrypi.core.dao.exceptions.PersistenceException;
import org.restberrypi.core.exceptions.BusinessException;

/**
 * User business layer implementation.
 */
public class UsersBOImpl implements UsersBO {
	private final UserDAO dao;

	public UsersBOImpl(UserDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<User> getAllUsers() throws BusinessException {
		try {
			return dao.findAll();
		} catch (PersistenceException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public User getUser(String id) throws BusinessException {
		try {
			return dao.findById(id);
		} catch (PersistenceException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public String addUser(User user) throws BusinessException {
		try {
			return dao.save(user);
		} catch (PersistenceException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void updateUser(User user) throws BusinessException {
		try {
			dao.update(user);
		} catch (PersistenceException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void removeUser(String id) throws BusinessException {
		try {
			dao.remove(id);
		} catch (PersistenceException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public User validateCredentials(String username, String password) throws BusinessException {
		try {
			User user = getUserByUsername(username);
			if (user.getPassword().equals(password)) {
				return user;
			}
			throw new BusinessException("Invalid credentials");
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public User getUserByUsername(String username) throws BusinessException {
		try {
			for (User user : dao.findAll()) {
				if (user.getUsername().equalsIgnoreCase(username)) {
					return user;
				}
			}
			throw new NotFoundException();
		} catch (PersistenceException e) {
			throw new BusinessException(e);
		}
	}

}
