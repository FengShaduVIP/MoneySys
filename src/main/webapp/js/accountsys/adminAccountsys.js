$(function () {
    $("#jqGrid").jqGrid({
        url: '../accountsys/adminList',
        datatype: "json",
        colModel: [			
       			{ label: 'id', name: 'id', width: 50, key: true, hidden : true},
       			{ label: '银行卡账号', name: 'bankNo', width: 80 }, 			
       			{ label: '银行名称', name: 'bankName', width: 80 }, 			
       			{ label: '开户人', name: 'openPerson', width: 80 }, 			
       			{ label: '存款（元）', name: 'moneyLeft', width: 80 }, 			
       			{ label: '开户日期', name: 'openDate', width: 80 }, 			
       			{ label: '类型', name: 'status', width: 80, formatter: function(value, options, row){
    				return value == 0 ? '<i class="fa-lg">定期</i>' : '<i class="fa-lg">活期</i>';
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
			
			location.href = "accountsys_add.html?id="+id;
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../accountsys/delete",
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