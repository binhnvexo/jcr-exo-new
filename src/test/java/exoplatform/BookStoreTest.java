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

import junit.framework.TestCase;

import org.exoplatform.container.StandaloneContainer;

import exoplatform.entity.Book;
import exoplatform.entity.User;
import exoplatform.entity.Book.CATEGORY;
import exoplatform.exception.DuplicateBookException;

/**
 * Created by The eXo Platform SAS
 * Author : BinhNV
 *          binhnv@exoplatform.com
 * Jul 17, 2012  
 */
public class BookStoreTest extends TestCase {
  
  private static BookStoreService service;
  private static StandaloneContainer container;
  
  static {
    initContainer();
  }
  
  public BookStoreTest() throws Exception {
    super();
  }
  
  private static void initContainer() {
    try {
      String configFile = BookStoreTest.class.getResource("/conf/portal/test-configuration.xml").toString();
      StandaloneContainer.addConfigurationURL(configFile);
      container = StandaloneContainer.getInstance();
      service = (BookStoreService) container.getComponentInstanceOfType(BookStoreService.class);
    } catch (Exception e) {
      throw new RuntimeException("fail to initialize container: " + e.getMessage(), e);
    }
  }
  
  @Override
  protected void setUp() throws Exception {
    
  }
  
  /**
   * create new database
   */
  public void testCreateDB() {
    service.createDB();
  }
  
  /**
   * get user by name with sql statement
   * 
   * @param username
   * @return
   */
  public void testGetUserByNameSQL() {
    String name = "binhnv";
    User user = service.getUserByNameSQL(name);
    assertNotNull(user);
  }
  
  /**
   * get user by name with xpath statement
   * 
   * @param username
   * @return
   */
  public void testGetUserByNameXPath() {
    String name = "binhnv";
    User user = service.getUserByNameXPath(name);
    assertNotNull(user);
  }
  
  /**
   * get user by name in range with sql statement
   * 
   * @param username
   * @return
   */
  public void testGetUserByNameLimtSQL() {
    String name = "binhnv";
    User user = service.getUserByNameLimtSQL(name);
    assertNotNull(user);
  }
  
  /**
   * get user by name in range with xpath statement
   * 
   * @param username
   * @return
   */
  public void testGetUserByNameLimtXPath() {
    String name = "binhnv";
    User user = service.getUserByNameLimtXPath(name);
    assertNotNull(user);
  }
  
  /**
   * get user by book name with sql statement
   * 
   * @param bookName
   * @return
   */
  public void testGetUserByBookQuery() {
    String bookName = "The sign of the four";
    User user = service.getUserByBookQuery(bookName);
    assertNotNull(user);
  }
  
}
