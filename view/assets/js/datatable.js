if (typeof(HK) == 'undefined') {
  HK = {};
}

/**
 *
 * el : table for which datatable is to be initialised
 * dataUrl : ajax url for fetching data
 * columnDetails : the column headers and which information in the ajax response will fit in which column
 * colDefs : mention visibilty for columns etc
 * aSort : default sorting
 * afterRowCreation : function to define any event to occur after a row is drawn and before it is shown on the screen
 * bDestroy : when dataTable is tried to initialised on the same table again to you want to reconstruct the
 *            datatable(value = true) or return the already constructed one(value = false)
 *            Note :  bRetrieve is opposite of bDestroy
 *
 */
HK.DataTable = function() {
  return {
    dataTable: function(el, dataUrl, columnDetails, colDefs, aSort, afterRowCreation, bDestroy) {
      var asInitVals = new Array();
      var oTable = el.dataTable({
        "aoColumnDefs": colDefs,
        "bProcessing": true,
        "sAjaxSource": dataUrl,
        "fnCreatedRow": afterRowCreation,
        "bAutoWidth": false,
        "bDeferRender": true,
        "oLanguage": {
          "sSearch": "Search all columns:"
        },
        "aoColumns": columnDetails,
        bDestroy: true
//        bRetrieve: !bDestroy
      });

      new FixedHeader(oTable);

      if ($("tfoot input").length > 0) {
        $("tfoot input").keyup(function () {
          /* Filter on the column (the index) of this element */
          oTable.fnFilter(this.value, $("tfoot input").index(this));
        });


        /*
         * Support functions to provide a little bit of 'user friendlyness' to the textboxes in
         * the footer
         */
        $("tfoot input").each(function (i) {
          asInitVals[i] = this.value;
        });

        $("tfoot input").focus(function () {
          if (this.className == "search_init")
          {
            this.className = "";
            this.value = "";
          }
        });

        $("tfoot input").blur(function (i) {
          if (this.value == "")
          {
            this.className = "search_init";
            this.value = asInitVals[$("tfoot input").index(this)];
          }
        });
      }

      return oTable;
    }
  };
};