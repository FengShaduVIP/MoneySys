var id = T.p("id");
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		chooseSys:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
    },
	methods: {
		getInfo: function(id){
			$.get("../choosesys/info/"+id, function(r){
                vm.chooseSys = r.chooseSys;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.chooseSys.id == null ? "../choosesys/save" : "../choosesys/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.chooseSys),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.back();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		back: function (event) {
			history.go(-1);
		}
	}
});