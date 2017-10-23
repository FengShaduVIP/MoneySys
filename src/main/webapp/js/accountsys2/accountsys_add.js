var id = T.p("id");
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		accountSys:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
    },
	methods: {
		getInfo: function(id){
			$.get("../accountsys/info/"+id, function(r){
                vm.accountSys = r.accountSys;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.accountSys.id == null ? "../accountsys/save" : "../accountsys/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.accountSys),
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