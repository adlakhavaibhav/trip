if (typeof(HK) == 'undefined') {
  HK = {};
}

if (typeof(CONTEXT_ROOT) == 'undefined') {
  CONTEXT_ROOT = '';
}

HK.GLBLS = {
  cntxt: CONTEXT_ROOT,
  api: CONTEXT_ROOT + '/api'
};

HK.autoCompleterUrls = {
  //brands
  allBrands: HK.GLBLS.api + "/admin/brands/suggest",
  allSpecialities: HK.GLBLS.api + "/core/specialities/all",

  //categories
  allCategoryNodes: HK.GLBLS.api + "/admin/category/suggest/all",
  primaryCategoryNodes: HK.GLBLS.api + "/admin/category/suggest/primary",
  trueCategoryNodes: HK.GLBLS.api + "/admin/category/suggest/true",

  //menu nodes
  allMenuNodes: HK.GLBLS.api + "/admin/menu/suggest/all",
  allMenuNodePages: HK.GLBLS.api + "/admin/page/menuNodePages",

  //expression
  expression: HK.GLBLS.api + "/admin/expression/",

  //offer
  allEnabledOffers: HK.GLBLS.api + "/admin/offer/enabled/all",
  allOfferTriggers: HK.GLBLS.api + "/admin/offer/trigger/all",
  offerTriggerById: HK.GLBLS.api + "/admin/offer/trigger/id/",
  allOfferActions: HK.GLBLS.api + "/admin/offer/action/all",
  offerActionById: HK.GLBLS.api + "/admin/offer/action/id/",

  //variant
  variantResource: HK.GLBLS.api + "/catalog/variant/",
  publishedVariantByIdSuffix: "/published",

  //freebie
  allFreebie: HK.GLBLS.api + "/admin/freebie/all"
};


jQuery(document).ready(function ($) {
  $('.auto-adjust').keyup(function () {
    adjustElemWidth($(this));
  });

  $('.auto-adjust').change(function () {
    adjustElemWidth($(this));
  });

  $('[type="submit"]').click(function () {
    var success = checkEmpty($(this)) && checkRadioGroup($(this)) && checkCheckBoxGroup($(this)) && checkMultiSelect($(this));
    if (success) {
      return true;
    } else {
      var ul = document.createElement('ul');
      ul.className = "errorList";
      var li = document.createElement('li');
      li.className = "errorMessage";

      $(li).append("Kindly mention all the required fields!");
      ul.appendChild(li);
      $('#error-messages').append(ul);
      $('#error-messages').css({
        backgroundColor: "firebrick"
      });
      $('#error-messages').show();
      return false;
    }
  });

  /* $('#storeSelect').change(function() {

   var srchBtn = $('.search');
   if ($(srchBtn)) {
   if ($(srchBtn).hasClass('include-store')) {
   $(srchBtn).click();
   }
   }

   });*/

  $('.verify').click(function () {
    var elem = $(this);
    var customMsg = "";
    if ($(elem).attr('message') != null) {
      customMsg = $(elem).attr('message').trim();
    }
    var confirmationMsg = (customMsg != "") ? customMsg : "Are you sure you want to perform this action?";

    return confirm(confirmationMsg);
  });

  setWidthLimits();
  adjustWidth();
  setDisabled();
  setReadOnly();
  manageOptionsTab();
});

jQuery(document).click(function () {
  $('#error-messages').hide();
  $('#error-messages').html(" ");
});

function adjustWidth() {
  $('.auto-adjust').each(function () {
    adjustElemWidth($(this));
  });
}

function adjustElemWidth(elem) {
  var textSize = elem.val().length * 7.5;

  elem.css({
    width: textSize
  });
}

function checkEmpty(submitElem) {
  var error = 0;
  var elem, val;
  submitElem.parents('form').find('.check-empty').each(function () {
    elem = $(this);
    elem.css({
      borderColor: "#CCCCCC"
    });

    val = elem.val().trim();
    if (val === "") {
      elem.css({
        borderColor: "red"
      });
      error = 1;
    }
  });
  return !error;
}

function setWidthLimits() {
  $('.auto-adjust').each(function () {
    var elem = $(this);
    var minElemWidth = 200;
    var parentElem = elem.parents()[0];

    parentElem = elem.parents()[0];
    minElemWidth = Math.min.apply(Math, new Array($(parentElem).width(), 200));
    elem.css({
      maxWidth: $(parentElem).width(),
      minWidth: minElemWidth
    });
  });
}

function getParamFromURL(name) {
  name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
  var regexS = '[\\?&]' + name + "=([^&#]*)";
  var regex = new RegExp(regexS);
  var results = regex.exec(window.location.href);
  if (results == null)
    return "";
  else
    return results[1];
}

function isValidInteger(value) {
  var intRegex = /^[0-9]*$/;
  return intRegex.test(value);
}

/**
 *
 * Ajax function start
 */
HK.Ajax = function () {
  return {
    getJson: function (url, onSuccess, onError) {
      jQuery.ajax({type: "GET", url: url, dataType: "json",
        success: function (json) {
          if (typeof onSuccess === "function")
            onSuccess.call(this, json);
        },
        error: function (xhr, a_status) {
          var errorMsg;
          if (typeof onError === "function") {
            onError.call(this, xhr, a_status);
          } else if (a_status === "error") { // Expected status: timeout/error/notmodified/parsererror
            if (xhr.status == 404) {
              errorMsg = " This request does not exist.";
            } else if (xhr.status == 500) {
              errorMsg = "An unexpected error occured on server while processing this request. Try Again.";
            }
          } else if (a_status === "timeout") {
            errorMsg = "Stay the patient course. Of little worth is your ire. The network is down.";
          } else if (a_status === "parsererror") {
            errorMsg = "Yesterday it worked. Today it is not working. The response from server couldn't be processed properly.";
          }
          if (errorMsg) {
            alert(errorMsg);
          }
        },
        beforeSend: function (xhr) {
          if (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
          }
        }
      });
    },
    postJson: function (url, map, onSuccess, onError) {
      jQuery.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: url,
        data: JSON.stringify(map),
        dataType: "json",
        success: function (json) {
          if (typeof onSuccess === "function")
            onSuccess.call(this, json);
        },
        error: function (xhr, a_status) {
          if (typeof onError === "function") {
            onError.call(this, xhr, a_status);
          } else if (a_status === "error") { // Expected status: timeout/error/notmodified/parsererror
            if (xhr.status == 404) {
              alert("You step in the stream, but the water has moved on. This request does not exist.");
            } else if (xhr.status == 500) {
              alert("An unexpected error occured on server while processing this request. Try Again.");
            }
          } else if (a_status === "timeout") {
            alert("Stay the patient course. Of little worth is your ire. The network is down.");
          } else if (a_status === "parsererror") {
            alert("Yesterday it worked. Today it is not working. The response from server couldn't be processed properly.");
          }
        },
        beforeSend: function (xhr) {
          if (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
          }
        }
      });
    }
  };
}();
/**
 *
 * Ajax function end
 */

/**
 *
 * String function start
 */
HK.String = function () {
  return {
    isBlank: function (str) {
      return (!str || /^\s*$/.test(str));
    },
    isEmpty: function (str) {
      return (!str || 0 === str.length);
    }
  };
}();

/**
 *
 * String function start
 */


function setDisabled() {
  if ($('.disabled')) {
    $('.disabled').each(function () {
      var elem = $(this);
      elem.attr("disabled", "disabled");
    });
  }
}

function setReadOnly() {
  if ($('.readonly')) {
    $('.readonly').each(function () {
      var elem = $(this);
      elem.attr("readonly", "readonly");
    });
  }
}

function checkRadioGroup(submitElem) {
  var error = 0;
  if (submitElem.parents('form').find('.checkRadioGroup').length > 0) {
    var selectedElems = submitElem.parents('form').find('.checkRadioGroup').filter("[type='radio']");
    error = checkSelectionGroup(selectedElems);
  }
  return !error;
}

function checkCheckBoxGroup(submitElem) {
  var error = 0;
  if (submitElem.parents('form').find('.checkCheckBoxGroup').length > 0) {
    var selectedElems = submitElem.parents('form').find('.checkCheckBoxGroup').filter("[type='checkbox']");
    error = checkSelectionGroup(selectedElems);
  }
  return !error;
}

function validateEmail(inputEmail) {
  var emailRegEx = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  return emailRegEx.test(inputEmail);
}

function checkMultiSelect(submitElem) {
  var error = 0;
  var multiSelects = submitElem.parents('form').find('.checkMultiSelect');
  $(multiSelects).each(function () {
    if ($(this).find('.selectedValues').length == 0) {
      error = 1;
    }
  });
  return !error;
}

function checkSelectionGroup(selElems) {
  var error = 0;

  var groupNames = new Array();
  selElems.each(function () {
    groupNames.push($(this).attr("name"));
  });
  groupNames = _.uniq(groupNames);
  var j;
  for (j = 0; j < groupNames.length; j++) {
    var selGroupName = groupNames[j];
    var groupElems = selElems.filter("[name='" + selGroupName + "']");

    //if neither of the selections of a group are checked, it is an error
    if (groupElems.filter(':checked').length == 0) {
      error = 1;
    }
  }
  return error;
}

function adjustOptionsTab(elem) {
  var parentHt = elem.height();
  var parentWidth = elem.width();
  var overlap = elem.attr('overlap') != null ? elem.attr('overlap') : 45;

  elem.find('.optionsTab').css({
    top: -parentHt,
    left: parentWidth - overlap
  });
}

function manageOptionsTab() {
  $('.hasOptions').hover(function () {
    adjustOptionsTab($(this));
    $(this).find('.optionsTab').show();
  });

  $('.hasOptions').mouseleave(function () {
    $(this).find('.optionsTab').hide();
  });
}

function previewImage(inputElem, previewElem, height, width) {
  var input = inputElem[0];
  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function (e) {
      previewElem.attr('src', e.target.result);

      if (width != "") {
        previewElem.width(width);
      }
      if (height != "") {
        previewElem.height(height);
      }
    };

    reader.readAsDataURL(input.files[0]);
  }
}
