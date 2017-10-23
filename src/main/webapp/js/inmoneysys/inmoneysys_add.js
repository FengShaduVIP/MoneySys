var id = T.p("id");
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		inMoneySys:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
    },
	methods: {
		getInfo: function(id){
			$.get("../inmoneysys/info/"+id, function(r){
                vm.inMoneySys = r.inMoneySys;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.inMoneySys.id == null ? "../inmoneysys/save" : "../inmoneysys/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.inMoneySys),
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