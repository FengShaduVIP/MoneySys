$(function () {
    $("#jqGrid").jqGrid({
        url: '../inmoneysys/listfamliy',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', width: 50, key: true,hidden : true },
			{ label: '项目名称', name: 'proName', width: 80 }, 			
			{ label: '姓名', name: 'userId', width: 80 }, 						
			{ label: '金额（元）', name: 'inMoney', width: 80 }, 	
			{ label: '日期', name: 'dateTime', width: 80 },
			{ label: '类型', name: 'status', width: 80, formatter: function(value, options, row){
				return value == 0 ? '<i class="fa-lg">收入</i>' : '<i class="fa-lg">支出</i>';
				}
			}	
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
			
			location.href = "outmoneysys_add.html?id="+id;
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../outmoneysys/delete",
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