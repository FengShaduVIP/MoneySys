var id = T.p("id");

var setting = {
	data: {
		simpleData: {
			enable: true,
			idKey: "menuId",
			pIdKey: "parentId",
			rootPId: -1
		},
		key: {
			url:"nourl"
		}
	}
};

var ztree ;
var vm = new Vue({
	el:'#rrapp',
	data:{
		title:"新增",
		person:{}
	},
	created: function() {
		if(id != null){
			this.title = "修改";
			this.getInfo(id)
		}
		//加载家庭树
		$.get("../sys/menu/select", function(r){
			ztree = $.fn.zTree.init($("#familyTree"), setting, r.menuList);
			var node = ztree.getNodeByParam("menuId", vm.menu.parentId);
			ztree.selectNode(node);
			
			vm.menu.parentName = node.name;
		})
    },
	methods: {
		getInfo: function(id){
			$.get("../person/info/"+id, function(r){
                vm.person = r.person;
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.person.id == null ? "../person/save" : "../person/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.person),
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
		familyTree: function(){
			layer.open({
				type: 1,
				offset: '50px',
				skin: 'layui-layer-molv',
				title: "选择菜单",
				area: ['300px', '450px'],
				shade: 0,
				shadeClose: false,
				content: jQuery("#familyLayer"),
				btn: ['确定', '取消'],
				btn1: function (index) {
					var node = ztree.getSelectedNodes();
					//选择上级菜单
					vm.menu.parentId = node[0].menuId;
					vm.menu.parentName = node[0].name;
					
					layer.close(index);
	            }
			});
		},
		back: function (event) {
			history.go(-1);
		}
	}
});