var monthNames = ["一月", "二月", "三月", "四月", "五月", "六月", 
                  "七月", "八月", "九月", "十月", "十一月", "十二月"];
var dayNames = ["日", "一", "二", "三", "四", "五", "六"];
var beforeShowFn = function() {
	var today = new Date();
	if(this.value != "") {
		var birthday = new Date();
		var arr = this.value.split("-");
		birthday.setFullYear(parseInt(arr[0])+100, parseInt(arr[1]), parseInt(arr[2]));
		if(today > birthday) {
			$(this).datepicker("option", "minDate", this.value);
		}
	}
};
var defaultLanguage = {
        "sLengthMenu": "每页显示 _MENU_ 条记录",
        "sZeroRecords": "无内容",
        "sInfo": " _START_ - _END_ (共 _TOTAL_ 条记录)",
        "sInfoEmpty": "无记录",
        "sInfoFiltered": "",
        "sSearch" : "搜索",
        "oPaginate": {
            "sPrevious": "前一页",
            "sNext": "后一页",
            "sLast": "尾页",
            "sFirst": "首页" 
          }
	};

var defaultDialogSetting = {
		width : 1000,
		height : "auto",
		modal : true,
		autoOpen : false,
		resizable : false,
		draggable : false,
		show : {
			effect : "blind",
			duration : 500
		},
		hide : {
			effect : "blind",
			duration : 500
		},
		open : function() {
			$("#error_msg").hide();
			$(".dialog_error_msg").text("");
		},
	}

var optionsOfDatepicker = {
		changeMonth : true,
		changeYear : true,
		monthNamesShort : monthNames,
		dayNamesMin : dayNames,
		dateFormat: 'yy-mm-dd',
		minDate : "-120Y",
		maxDate : "-0Y",
		defaultDate: "0Y",
		yearRange:"-120:+0",
		beforeShow : beforeShowFn
	};