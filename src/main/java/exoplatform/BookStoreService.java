/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package exoplatform;

import javax.jcr.Node;

import exoplatform.entity.User;
import exoplatform.entity.Book.CATEGORY;
import exoplatform.exception.DuplicateBookException;

/**
 * Created by The eXo Platform SAS
 * Author : BinhNV
 *          binhnv@exoplatform.com
 * Jul 19, 2012  
 */
public interface BookStoreService {

  /**
   * create new database
   */
  public void createDB();
  
  /**
   * get user by name with sql statement
   * 
   * @param username
   * @return
   */
  public User getUserByNameSQL(String username);
  
  /**
   * get user by name with xpath statement
   * 
   * @param username
   * @return
   */
  public User getUserByNameXPath(String username);
  
  /**
   * get user by name in range with sql statement
   * 
   * @param username
   * @return
   */
  public User getUserByNameLimtSQL(String username);
  
  /**
   * get user by name in range with xpath statement
   * 
   * @param username
   * @return
   */
  public User getUserByNameLimtXPath(String username);
  
  /**
   * get user by book name with sql statement
   * 
   * @param bookName
   * @return
   */
  public User getUserByBookQuery(String bookName);
  
  /**
   * add new book to datastorage
   * 
   * @param bookName
   * @param category
   * @param content
   * @return
   * @throws DuplicateBookException
   */
  public Node addBook(String bookName, CATEGORY category, String content, String nodePath) throws DuplicateBookException;
  
}
