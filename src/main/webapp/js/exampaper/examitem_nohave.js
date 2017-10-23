
var vm_nohave = new Vue({
	el:'#exampaperItem_nohave',
	data:{
		
	},
	methods: {
		addItem: function (event) {
			var ids=$('#jqGridItem_nohave').jqGrid('getGridParam','selarrrow');
			if(ids == null){
				return ;
			}
			$.ajax({
				type: "POST",
			    url: "../sysitem/delete", 
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
		}
	}
});