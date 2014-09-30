if (typeof(HK) == 'undefined') {
  HK = {};
}

/*
 * el: target element for autocomplete
 * dataUrl: url resource that will return json data
 * onSuccess: method to be called on successfully receiving json data
 * onSelect: method to be called on the select event
 * minLength: minimum length on which autocomplete shall be triggered
 */
HK.AutoCompleter = function() {
  return {
    autocomplete: function(el, dataUrl, onSuccess, onSelect, minlength) {
      el.autocomplete({
        source:function(request, response) {
          $.ajax({
            url:dataUrl,
            dataType: "json",
            data:{
              q: request.term
            },
            success: function(responseData) {
              /*var item = [
               {
               name: "Custom text at Top",
               count: 0,
               fulfills_required: false
               },
               {
               name: "Custom text at bottom",
               count: 7,
               fulfills_required: false
               }
               ];
               //Adding custom item at the top of list.

               //Adding custom item at the end of list.
               responseData.results.splice(responseData.results.length, 0, item[1].name);*/

              var autoId = el.parent('.autoParent').find('.autoId');
              var itemsList = onSuccess.call(this, responseData, autoId);
              response(itemsList);
            }
          });
        },
        minLength:minlength,
        delay:2000,
        select: function(event, ui) {
          if (onSelect != null) {
            onSelect.call(this, ui);
          }
        }
      });
    }
  }
};

HK.AutoCompleterStatic = function() {
  return {
    autocomplete: function(el, dataUrl, onFilter, onSuccess, onSelect, minlength) {
      var itemsList = new Array();
      var NoResultsLabel = "No Results";

      $.ajax({
        url:dataUrl,
        dataType: "json",
        success: function(responseData) {
          var autoId = el.parent('.autoParent').find('.autoId');
          itemsList = onSuccess.call(this, responseData, autoId);
        },
        async : false
      });

      el.autocomplete({
        source: function(request, response) {
          var results;
          if (onFilter == null) {
            results = $.ui.autocomplete.filter(itemsList, request.term);
          } else {
            results = onFilter.call(this, itemsList, request.term);
          }

          if (!results.length) {
            results = [NoResultsLabel];
          }

          response(results);
        },
        minLength:minlength,
        select: function(event, ui) {
          if (ui.item.label === NoResultsLabel) {
            event.preventDefault();
          }
          if (onSelect != null) {
            onSelect.call(this, ui);
          }
        },
        focus: function (event, ui) {
          if (ui.item.label === NoResultsLabel) {
            event.preventDefault();
          }
        }/*,
         filter: function (array, term) {
         if (onFilter != null) {
         onFilter.call(array, term);
         }
         }*/
      });
    }
  };
};