
var vm_have = new Vue({
	el:'#exampaperItem_have',
	data:{
		
	},
	methods: {
		delItem: function (event) {
			var ids=$('#jqGridItem_have').jqGrid('getGridParam','selarrrow');
			if(ids == null){
				return ;
			}
			confirm('确定要删除选中的记录？', function(){
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
			});
		}
	}
});