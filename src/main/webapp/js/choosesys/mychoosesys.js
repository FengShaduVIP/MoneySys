$(function () {
    $("#jqGrid").jqGrid({
        url: '../choosesys/myPersonlist',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', width: 50, key: true,hidden : true },
			{ label: '投资人', name: 'userName', width: 80 },
			{ label: '项目编号', name: 'proNo', width: 80 }, 			
			{ label: '项目名称', name: 'proName', width: 80 }, 			
			{ label: '投资日期', name: 'chooseDate', width: 80 }, 			
			{ label: '投资金额', name: 'putMoney', width: 80 }, 			
			{ label: '投资收入', name: 'inMoney', width: 80 }			
        ],
		viewrecords: true,
        height: 400,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		
	},
	methods: {
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
			location.href = "choosesys_add.html?id="+id;
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../choosesys/delete",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		}
	}
});