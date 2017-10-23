var id = T.p("id");
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		outMoneySys:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
    },
	methods: {
		getInfo: function(id){
			$.get("../outmoneysys/info/"+id, function(r){
                vm.outMoneySys = r.outMoneySys;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.outMoneySys.id == null ? "../outmoneysys/save" : "../outmoneysys/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.outMoneySys),
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