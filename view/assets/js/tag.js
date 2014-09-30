jQuery(document).ready(function () {

    $("#addTag").click(function() {
        var data = $("#tagName1").val();
        if (data == "" || data == null) {
            alert("Value can't be Empty");
            return false;
        }
        var arr = data.split(",");
        for(var i = 0;i<arr.length;i++){
            var text;
            var bool = true;
            arr[i] = $.trim(arr[i]);
            if(arr[i].length!=0){
                $(".divTag").each(function() {
                    text = $(this).text();
                    text = $.trim(text);
                    //alert(text + " "+ text.length);
                    if (text == arr[i]) {
                        bool = false;
                    }
                });
                if(bool)
                    $("#addTags").append("<div class=\"col_2\"><fieldset><h4><ul class=\"menu vertical\"><li><a class=\"divTag\" href='#'>" + arr[i] + "</a></li><li><a class=\"divX\" href='#'><span style=\"color:red;\" >x</span></a></li></ul></h4></fieldset></div>");
            }
        }

        $("#tagName1").val("");
    });
    $(".divX").live('click', function() {
        $(this).parents("div:first").remove();
    });
    $("#saveAllTags").click(function() {
        var counter = 0;
        var set = new Array();
        $(".divTag").each(function() {
            var data = $(this).text();
            data = $.trim(data);
            var obj = new Object();
            obj.name = data;
            set[counter++] = obj;
        });
        var jsonValues = JSON.stringify(set);
        $("#newAddTags").attr("value", jsonValues);
        return true;
    });
});