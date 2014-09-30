package com.td.pact.query;

/**
 * @author adlakha.vaibhav
 */
public enum SearchTypeEnum {

  EXACT_MATCH("EM"), CONTAINING_MATCH("CM"), SOUNDEX_MATCH("SM");

  private String type;

  private SearchTypeEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static SearchTypeEnum getSearchTypeFromString(String searchType) {
    for (SearchTypeEnum searchTypeEnum : SearchTypeEnum.values()) {
      if (searchTypeEnum.getType().equalsIgnoreCase(searchType)) {
        return searchTypeEnum;
      }
    }

    return null;
  }
}
