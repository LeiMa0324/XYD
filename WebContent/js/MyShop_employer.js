/**
 * 
 */

$(function() {
	$("#searchemp_btn").click(searchOrder);
	
	getAllEmployer(1);
});


//检索所有员工
function searchAllEmp(page){
    
    $.post("ShopServlet", {
        op:"get_employer_list_by_shop_id_and_keyword",
        
        //检索所有emp，关键字用-1
        empname_keyword:-1, 
        id:id,
        page:page
            
    }, searchEmps_render, "xml");
}


//通过关键字检索员工
function searchEmpListByKeyword(){
	var empname_keyword = $("#searchBox").val();
	
	if(empname_keyword=="") {
		alert("员工姓名不能为空！");
		return false;
	}
	
	$.post("ShopServlet", {
	    op:"get_employer_list_by_shop_id_and_keyword",
		empname_keyword:empname_keyword,
		id:id,
		page:page
			
	}, searchEmps_render, "xml");
}

function searchEmps_render(data){
	alert("员工成功");
	//写回调后的xml怎么展示在页面上 todo

}