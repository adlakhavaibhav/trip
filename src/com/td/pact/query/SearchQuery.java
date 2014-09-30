package com.td.pact.query;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/29/14
 * Time: 5:40 PM
 */
public interface SearchQuery {

  public static final String PAGE_NO_KEY = "pageNo";

  public static final String ROWS_KEY = "rows";

  /*public static final String CACHE_KEY_SEPARATOR = "-"; */

  public SearchQuery setOrderByField(String orderByField);

  public SearchQuery setOrderDirection(String orderDirection);

  public SearchQuery setPageNo(Integer pageNo);

  public SearchQuery setRows(Integer rows);

  /**
   * query string is specific to implementations.
   *
   * @return
   */
  public String getQueryString();

  /**
   * query string is specific to implementations.
   *
   * @return
   */
  public String getQueryString(boolean isCountQuery);

  /**
   * parameters will also be specific to implementation
   *
   * @return
   */
  public Map<String, Object> getQueryParams();

  /**
   * Get result size constraints viz. size and start for result list.
   *
   * @return
   */
  public Map<String, Object> getResultConstratins();

  /**
   * this will be the start of results, page no in case results are paginated
   *
   * @return
   */
  public int getPageNo();


  /**
   * max number of rows that search query should return
   *
   * @return
   */
  public int getRows();

  @SuppressWarnings("rawtypes")
  public List execute();


  public int count();

  /**//**
   * this will be used if we want to cache search results for a particular query, throws UnSupportedOperationException if results cannot be cached
   * @return
   *//*
  public String getCacheKey() throws UnsupportedOperationException;*/
}
