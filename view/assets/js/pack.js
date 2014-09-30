if (typeof(HK) == 'undefined') {
  HK = {};
}

/*
 *  Classes:
 *    valid-pack-sv : valid row
 *    invalid-pack-sv : invalid row
 *
 *  Elements:
 *    $('a.add-sv-again') :  Adding a store variant again to pack
 *    $('a.remove-sv') :  Removing a store variant from pack
 *    $('a#add-sv') :  Adding a new store variant to pack
 *
 *    $('tr.valid-pack-sv'): row defining valid rows to be added in the table
 *    $('input:hidden#pack-id') : pack id
 *      Elements in every tr representing following info:
 *       ('input:hidden.id') : id for packStoreVariant
 *       ('td.pack-sv-id') : id for storeVariant added to pack
 */

HK.Pack = function() {
  return {
    buildPack: function(packForm) {
      var validPackStoreVariants = $('tr.valid-pack-sv');
      var ctr = 0;
      var elemsToAppend = "";
      var id,packId,packSvId,packSvQty;

      validPackStoreVariants.each(function() {
        id = $(this).find('input:hidden.id').val();
        packId = $('input:hidden#pack-id').val();
        packSvId = $(this).find('td.pack-sv-id').attr("val");
        packSvQty = $(this).find('td.pack-sv-qty').attr("val");

        if (null == packSvQty) {
          packSvQty = $(this).find('td.pack-sv-qty input:text.sv-qty').val();
        }

        if (id != null) {
          elemsToAppend += "<input type='hidden' name='packDTO.packStoreVariantDTOList[" + ctr + "].id' value='" + id + "'/>";
          elemsToAppend += "<input type='hidden' name='packDTO.packStoreVariantDTOList[" + ctr + "].packId' value='" + packId + "'/>";
        }

        elemsToAppend += "<input type='hidden' name='packDTO.packStoreVariantDTOList[" + ctr + "].storeVariantId' value='" + packSvId + "'/>";
        elemsToAppend += "<input type='hidden' name='packDTO.packStoreVariantDTOList[" + ctr + "].qty' value='" + packSvQty + "'/>";

        ctr++;
      });
      packForm.append(elemsToAppend);
    },

    getNumberOfValidPackStoreVariants: function() {
      //      return $('tr.valid-pack-sv').size();
      var totalQty = 0;
      $('tr.valid-pack-sv').each(function() {
        var packSvQty = $(this).find('td.pack-sv-qty').attr("val");

        if (null == packSvQty) {
          packSvQty = $(this).find('td.pack-sv-qty input:text.sv-qty').val();
        }

        totalQty += parseInt(packSvQty);
      });

      return totalQty;
    },

    removeSvFromPack: function(elem) {
      var parentTr = $(elem).parents('tr');
      parentTr.removeClass("valid-pack-sv");
      parentTr.addClass("invalid-pack-sv notice error");

      parentTr.find('input:text.sv-qty').removeClass('check-empty');
      parentTr.find('a.add-sv-again').show();
      $(elem).hide();
      return true;
    },

    addSvAgainToPack: function(elem) {
      var parentTr = $(elem).parents('tr');
      var svIdBeingAdded = parentTr.find('td.pack-sv-id').attr("val");
      var isValidRequest = true;
      $('tr.valid-pack-sv').each(function() {
        if ($(this).find('td.pack-sv-id').attr("val") === svIdBeingAdded) {
          alert("Variant already added in pack!");
          isValidRequest = false;
          return false;
        }
      });

      if (!isValidRequest) {
        return false;
      }

      parentTr.addClass("valid-pack-sv");
      parentTr.removeClass("invalid-pack-sv notice error");

      parentTr.find('input:text.sv-qty').addClass('check-empty');
      parentTr.find('a.remove-sv').show();
      $(elem).hide();
      return true;
    } ,

    addNewSvToPack : function(svId, packStoreVariantTable) {
      var isValidRequest = true;
      $('tr.valid-pack-sv').each(function() {
        if ($(this).find('td.pack-sv-id').attr("val") === svId) {
          alert("Variant already added in pack!");
          isValidRequest = false;
          return false;
        }
      });

      if (!isValidRequest) {
        return false;
      }

      $.ajax({
        url:HK.autoCompleterUrls.variantResource + svId,
        dataType: "json",
        success: function(responseData) {
          var storeVariant = responseData.results;
          if (storeVariant != null) {
            var newSvRow = "<tr class='valid-pack-sv'><td class='pack-sv-id' val='" + storeVariant.id + "'>";
            newSvRow += storeVariant.id + "</td> <td>";
            newSvRow += storeVariant.nm + "</td> <td class='pack-sv-qty'>";
            newSvRow += "<input type='text' class='sv-qty check-empty'/></td> <td>";
            newSvRow += "<a href='javascript:void(0)' onclick='HK.Pack().addSvAgainToPack(this);' class='button blue small add-sv-again' style='display:none;'>Add</a>";
            newSvRow += "<a href='javascript:void(0)' onclick='HK.Pack().removeSvFromPack(this);' class='button blue small remove-sv'>Remove</a>";
            newSvRow += "</td></tr>";

            packStoreVariantTable.append(newSvRow);
          } else {
            alert("Store variant Id: " + svId + " is invalid!");
          }
        }
      });
    }
  };
};
