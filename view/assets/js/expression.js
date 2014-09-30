jQuery(document).ready(function () {


  // This code will show the selected entity on page
  $('#selectEntity').live("click", function () {

    var selectEntityValue = $('#selectEntity').val();

    if (selectEntityValue == 'brand') {
      if ($('#prodDiv').css('display') != 'none') {
        alert("You can't add this entity with Product Entity");
      } else {
        $('#brandDiv').show();
      }
    } else if (selectEntityValue == 'category') {
      if ($('#prodDiv').css('display') != 'none') {
        alert("You can't add this entity with Product Entity");
      } else {
        $('#categoryDiv').show();
      }
    } else if (selectEntityValue == 'price') {
      if ($('#prodDiv').css('display') != 'none') {
        alert("You can't add this entity with Product Entity");
      } else {
        $('#priceDiv').show();
      }
    } else if (selectEntityValue == 'product') {
      if ($('#priceDiv').css('display') != 'none' || $('#categoryDiv').css('display') != 'none' || $('#brandDiv').css('display') != 'none') {
        alert("Products can't be add with other entities");
      } else {
        $('#prodDiv').show();
      }
    }
    $('#selectEntity').val("");
  });

  $('.delPrice').live("click", function () {
    $(this).parent().remove();
  });

  $('#save').click(function () {
    var count = 0;
    var eqAttr = false;
    var gtAttr = false;
    var geAttr = false;
    var ltAttr = false;
    var leAttr = false;
    var bool = true;
    var gPrice;
    var lPrice;

    var expressionName = $('#expressionName').val();

    if (expressionName == null || expressionName == "") {
      alert("Enter Expression Name!!!!");
      return false;
    }

    if ($('#priceDiv').css('display') != 'none') {
      $('.priceSelect').each(function () {
        count++;
        var priceSelectValue = $(this).val();
        var priceValue = $(this).parent().children('.priceValue').val();

        if (priceSelectValue == "" || priceValue == null || priceValue == "" || isNaN(priceValue)) {
          alert("Enter Valid Attribute for Price!!!");
          bool = false;
          return false;
        }

        if ((eqAttr && count > 1) || (priceSelectValue == "eq" && count > 1)) {
          alert("Only one Price can come with equals!!!");
          bool = false;
          return false;
        }

        if ((gtAttr && priceSelectValue == "gt") || (gtAttr && priceSelectValue == "ge") || (geAttr && priceSelectValue == "ge") || (geAttr && priceSelectValue == "gt")) {
          alert("Please Enter Valid Price Range!!!");
          bool = false;
          return false;
        }

        if ((ltAttr && priceSelectValue == "lt") || (ltAttr && priceSelectValue == "le") || (leAttr && priceSelectValue == "le") || (leAttr && priceSelectValue == "lt")) {
          alert("Please Enter Valid Price Range!!!");
          bool = false;
          return false;
        }

        if (priceSelectValue == "eq") {
          eqAttr = true;
        }
        if (priceSelectValue == "gt") {
          gPrice = priceValue;
          gtAttr = true;
        }
        if (priceSelectValue == "ge") {
          gPrice = priceValue;
          geAttr = true;
        }
        if (priceSelectValue == "lt") {
          lPrice = priceValue;
          ltAttr = true;
        }
        if (priceSelectValue == "le") {
          lPrice = priceValue;
          leAttr = true;
        }

      });

      if ((leAttr == true || ltAttr == true) && (geAttr == true || gtAttr == true)) {
        if (parseInt(gPrice) > parseInt(lPrice)) {
          alert("Please Enter Valid Range for Less than and Greater than Price");
          return false;
        }
      }

      count = 0;
      var priceFinalValues = "";
      $('.priceSelect').each(function () {
        count++;
        var priceSelectValue = $(this).val();
        var priceValue = $(this).parent().children('.priceValue').val();

        if (count == 1) {
          priceFinalValues = "pr" + "(" + priceSelectValue + ")" + priceValue;
        } else {
          priceFinalValues += "&" + "pr" + "(" + priceSelectValue + ")" + priceValue;
        }
      });
      $('#priceId').val(priceFinalValues);
    }

    if (!bool) {
      return false;
    }

    var brandFinalValues = "";
    var brandQty = 0;
    var exprType = $("#expr-type").val();

    $('.brandId').each(function () {
      brandQty++;
      var brand = $(this).attr("data-id");
      if (brandFinalValues == "") {
        brandFinalValues = brand + ",";
      } else {
        brandFinalValues += brand + ",";
      }
    });

    brandFinalValues = brandFinalValues.substring(0, brandFinalValues.length - 1);
    $("#brandFinalValues").val(brandFinalValues);

    var categoryFinalValues = "";
    var catQty = 0;

    $('.categoryId').each(function () {
      catQty++;
      var category = $(this).attr("data-id");
      if (categoryFinalValues == "") {
        categoryFinalValues = category + ",";
      } else {
        categoryFinalValues += category + ",";
      }
    });


    if (exprType == $('#menuExprType').val()) {
      if (brandQty > 1 && catQty == 0) {
        alert("For Adding Multiple Brands in expression there must be atleast one Category");
        return false;
      }

      if (brandQty == 1 && catQty == 0) {
        alert("Page Created by this expression will be considered as brand page only");
      }
    }

    categoryFinalValues = categoryFinalValues.substring(0, categoryFinalValues.length - 1);
    $("#categoryFinalValues").val(categoryFinalValues);

    var productFinalValues = "";

    $('.productId').each(function () {
      var product = $(this).attr("data-id");
      if (productFinalValues == "") {
        productFinalValues = product + ",";
      } else {
        productFinalValues += product + ",";
      }
    });

    productFinalValues = productFinalValues.substring(0, productFinalValues.length - 1);
    $('#productsFinalValues').val(productFinalValues);

    var brandId = $('#brandFinalValues').val();
    var categoryId = $('#categoryFinalValues').val();
    var productsId = $('#productsFinalValues').val();
    var priceValue = $('#priceId').val();

    if ((brandId == "" || brandId == null) && (priceValue == null || priceValue == "") && (categoryId == null || categoryId == "") && (productsId == null || productsId == "")) {
      alert("Enter Expression!!!");
      return false;
    }

    /*if ((brandId == "" || brandId == null) && (priceValue != null || priceValue != "") && (categoryId == null || categoryId == "")) {
      alert("Please Enter atleast category, brand with price or Only Products");
      return false;
    }*/

  });

  $('#prdctId').change(function() {
    var storeId = $('#storeSelect').val();
    var productId = $(this).val();

    if (productId == null || productId == "" || isNaN(productId)) {
      alert("Please Enter Valid Product Id");
      return false;
    }

    $.ajax({
      url:"/api/catalog/product/" + productId,
      dataType: "json",
      success: function(responseData) {
        var storeProduct = responseData.results;
        if (storeProduct != null) {
          var bool = true;
          $('.productId').each(function () {
            var product = $(this).attr("data-id");
            if (product == storeProduct.id) {
              alert("Product with given Id is already added in the list");
              bool = false;
              return false;
            }
          });
          if (!bool) {
            return false;
          }
          $('.slctProduct').append("<span class='productId' style='background-color:white;font-size:1.2em;padding:3px;line-height: 1.7em;margin-right:10px;white-space: nowrap' data-id='" + storeProduct.id + "'>" + storeProduct.name + "<a href='javascript:void(0)' onclick='$(this).parents(\".productId\").remove()' class='icon darkblue small' data-icon='m' title='Delete option' style='display: inline-block;vertical-align: bottom'><span aria-hidden=true>m</span></a></span>");
        } else {
          alert("Store Product ID entered is Invalid!");
        }
      }
    });
    $(this).val('');
  });

});