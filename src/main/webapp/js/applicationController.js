var app = angular.module("app", []);
app.controller('MainController', function($scope) {
	var vm = this;
	
	

	function activate() {
		vm.getAllMasterRules();
	}

	vm.sortTableBy = function(propertyName) {
		vm.reverse = (vm.propertyName === propertyName) ? !vm.reverse : false;
		vm.propertyName = propertyName;
	};

	vm.getAllMasterRules = function() {

		RulesManagementService.getAllMasterRule(

			{
				callback: function(resp) {
					vm.ruleArray = JSON.parse(resp);
					$scope.$apply();
				},

				errorHandler: function(message, exception) {
					if (exception.cause && exception.cause.errorCode == 2292)
						message = "Cannot Retrieve rules details."
					swal({
						title: 'Error!',
						text: message,
						type: 'error'
					});
				}
			}
		);

	}

	vm.addNewInputParameter = function() {
		vm.parameterPriority = vm.parameterPriority + 1
		var inputParameter = {
			parameterName: '',
			mandatoryIndicator: '',
			errorParameter: null,
			errorMandatory: null,
			parameterPriority: vm.parameterPriority
		};
		vm.inputParameterArray.push(inputParameter);
	}

	vm.changePage = function() {
		vm.showAddRuleTab = false;
		vm.packageError = "";
		vm.descriptionError = '';
		vm.outputParameterArray.splice(0, vm.outputParameterArray.length);
		vm.inputParameterArray.splice(0, vm.inputParameterArray.length);
		vm.ruleDescription = '';
		vm.rulePackage = '';
		vm.parameterPriority = 0;
	}
	vm.deleteMasterRule = function(ruleMasterId) {
		swal({
			title: 'Are you sure?',
			text: "You won't be able to revert this!",
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Yes, delete it!',
			cancelButtonText: 'No, cancel!',
			confirmButtonClass: 'btn btn-success',
			cancelButtonClass: 'btn btn-danger',
			buttonsStyling: false,
			reverseButtons: true
		}).then(function(result) {

			if (result.value) {
				RulesManagementService.deleteMasterRule(ruleMasterId,

					{
						callback: function(resp) {
							var result = JSON.parse(resp);
							if (result.error) {
								swal({
									title: 'Error!',
									text: "Unable to delete Some error Occurred",
									type: 'error'
								});
							} else {
								vm.getAllMasterRules();
								swal(
									'Deleted!',
									'Master Rule Deleted',
									'success'
								)
							}
							$scope.$apply();
						},

						errorHandler: function(message, exception) {
							if (exception.cause && exception.cause.errorCode == 2292)
								message = "Cannot delete this Some error Occurred."
							swal({
								title: 'Error!',
								text: message,
								type: 'error'
							});
						}
					}
				);
			} else if (result.dismiss === 'cancel') {
				swal(
					'Cancelled',
					'Delete Cancelled)',
					'error'
				)
			}
		})

	}

	vm.addNewOutputParameter = function() {
		var outputParameter = {
			parameterName: '',
			mandatoryIndicator: '',
			repeatableCode: '',
			errorParameter: null,
			errorMandatory: null,
			parameterPriority: 1
		};
		vm.outputParameterArray.push(outputParameter);
	}

	vm.removeInputParameter = function(index) {
		if (index > -1) {

			vm.inputParameterArray.splice(index, 1);
		}
	}

	vm.removeOutputParameter = function(index) {

		if (index > -1) {
			vm.outputParameterArray.splice(index, 1);

		}
	}

	vm.removeEditInputParameter = function(index, ruleId) {

		if (index > -1) {
			vm.editDeleteParameter.push(ruleId);
			vm.inputParameterArray.splice(index, 1);
		}
	}

	vm.removeEditOutputParameter = function(index, ruleId) {

		if (index > -1) {
			vm.editDeleteParameter.push(ruleId);
			vm.outputParameterArray.splice(index, 1);
		}
	}

	vm.cancelSavingRule = function() {

		var validationPass = true;
		vm.descriptionError = "";
		vm.packageError = "";
		vm.outputParameterArray.splice(0, vm.outputParameterArray.length);
		vm.inputParameterArray.splice(0, vm.inputParameterArray.length);
		vm.ruleDescription = '';
		vm.rulePackage = '';
		vm.parameterPriority = 0;
		vm.changePage();

	}

	vm.editMasterRule = function(masterRuleId) {
		vm.ruleMasterId = masterRuleId;
		editMasterRule(vm.ruleMasterId);
	}

	function editMasterRule(masterRuleId) {
		vm.showLoading = true;
		RulesManagementService.fetchMasterRule(masterRuleId,

			{
				callback: function(resp) {
					var result = JSON.parse(resp);
					vm.showLoading = false;
					if (result.error) {
						swal({
							title: 'Error!',
							text: "Unable to fetch rules details",
							type: 'error'
						});
					} else {

						vm.inputParameterArray = JSON.parse(result.input);
						vm.outputParameterArray = JSON.parse(result.output);
						var masterRule = JSON.parse(result.masterRule);
						vm.ruleDescription = masterRule.ruleDescription;
						vm.rulePackage = masterRule.packageName;
						vm.showEditScreen = true;
					}
					$scope.$apply();
				}
			}
		);

	}
	vm.saveMasterRule = function() {
		var temp = validateAddRule();
		vm.showLoading = true;
		if (temp) {
			var request = {
				ruleDescription: vm.ruleDescription,
				rulepackage: vm.rulePackage,
				inputparameters: vm.inputParameterArray,
				outPutparameters: vm.outputParameterArray
			}

			RulesManagementService.saveNewMasterRule(
				JSON.stringify(request), {
					callback: function(resp) {

						vm.getAllMasterRules();
						vm.descriptionError = "";
						vm.packageError = "";
						vm.outputParameterArray.splice(0, vm.outputParameterArray.length);
						vm.inputParameterArray.splice(0, vm.inputParameterArray.length);
						vm.ruleDescription = '';
						vm.rulePackage = '';
						vm.showAddRuleTab = false;
						vm.showLoading = false;
					},
					errorHandler: function(message, exception) {
						vm.selectedParaListType = null;
						vm.paraName = "";
						message = "Cannot save this Master rule.";
						swal({
							title: 'Error!',
							text: message,
							type: 'error'
						});
					}
				}
			);

		} else {
			vm.showLoading = false;
		}

	}


	vm.UpdateMasterRule = function(ruleMasterId) {
		vm.showLoading = true;
		var request = {
			ruleDescription: vm.ruleDescription,
			ruleMasterId: ruleMasterId,
			rulepackage: vm.rulePackage,
			inputparameters: vm.inputParameterArray,
			outPutparameters: vm.outputParameterArray,
			deletedRuleParameter: vm.editDeleteParameter
		}


		RulesManagementService.updateMasterRule(
			JSON.stringify(request), {
				callback: function(resp) {
					var result = JSON.parse(resp);
					vm.showLoading = false;
					if (result.error) {
						swal({
							title: 'Error!',
							text: "Unable to Update the records",
							type: 'error'
						});
						editMasterRule(vm.ruleMasterId);
					} else {
						if (result.validation) {

							vm.getAllMasterRules();
							vm.showAddRuleTab = false;
							vm.showEditScreen = false;
							vm.inputParameterArray = [];
							vm.outputParameterArray = [];
							vm.ruleDescription = '';
							vm.rulePackage = '';
							vm.descriptionError = null;
							vm.packageError = null;
							vm.editDeleteParameter = [];
							swal('Updated Successfully');
						} else {
							vm.inputParameterArray = JSON.parse(result.inputParameters);
							vm.outputParameterArray = JSON.parse(result.outputParameters);
							vm.descriptionError = result.descriptionError;
							vm.packageError = result.packageError;
						}

					}

					$scope.$apply();
				},
				errorHandler: function(message, exception) {
					swal({
						title: 'Error!',
						text: "Error Occured Please try again",
						type: 'error',
						timer: 000
					});
				}
			}
		);
	}

	function validateAddRule() {
		vm.newAddedParameters = [];
		var validationPass = true;
		vm.descriptionError = "";
		vm.packageError = "";

		if (vm.ruleDescription == '') {
			vm.descriptionError = "rule description is mandatory";
			validationPass = false;

		} else {
			if (vm.ruleArray.some(checkForDescription)) {
				vm.descriptionError = "this rule description is already present.Cannot be duplicate";
				validationPass = false;
			}
		}
		if (vm.rulePackage == '') {
			vm.packageError = "rule package is mandatory";
			validationPass = false;

		} else {
			if (vm.ruleArray.some(checkForPackage)) {
				vm.packageError = "this rule checkForPackage is already present.Cannot be duplicate";
				validationPass = false;
			}
		}
		if (vm.inputParameterArray.length == 0 || vm.outputParameterArray.length == 0) {
			swal({
				title: 'Error!',
				text: "Please fill all the mandatory fields.",
				type: 'error'
			});
			validationPass = false;
		}
		for (i in vm.inputParameterArray) {
			vm.inputParameterArray[i].errorParameter = '';
			vm.inputParameterArray[i].errorMandatory = '';
			if (vm.inputParameterArray[i].parameterName === '') {
				vm.inputParameterArray[i].errorParameter = "Parameter Name is mandatory"
				validationPass = false;

			} else {
				if (vm.newAddedParameters.some(checkForInputParamaters)) {
					vm.inputParameterArray[i].errorParameter = "Cannot have more than one parameter of same name";
					validationPass = false;
				} else {
					vm.newAddedParameters.push(vm.inputParameterArray[i]);
				}
			}
			if (vm.inputParameterArray[i].mandatoryIndicator === '') {
				validationPass = false;
				vm.inputParameterArray[i].errorMandatory = "Please select the value for indicator"
			}
		}

		for (j in vm.outputParameterArray) {
			vm.outputParameterArray[j].errorParameter = '';
			vm.outputParameterArray[j].errorMandatory = '';
			if (vm.outputParameterArray[j].parameterName === '') {
				vm.outputParameterArray[j].errorParameter = "Parameter Name is mandatory"
				validationPass = false;

			} else {
				if (vm.newAddedParameters.some(checkForOutputParamaters)) {
					vm.outputParameterArray[j].errorParameter = "Cannot have more than one parameter of same name";
					validationPass = false;
				} else {
					vm.newAddedParameters.push(vm.outputParameterArray[j]);
				}
			}
			if (vm.outputParameterArray[j].mandatoryIndicator === '') {
				validationPass = false;
				vm.outputParameterArray[j].errorMandatory = "Please select the value for indicator"
			}
		}
		vm.newAddedParameters = [];
		return validationPass;
	}

	vm.backToMasterList = function() {
		var validationPass = true;
		vm.descriptionError = "";
		vm.packageError = "";
		vm.outputParameterArray.splice(0, vm.outputParameterArray.length);
		vm.inputParameterArray.splice(0, vm.inputParameterArray.length);
		vm.ruleDescription = '';
		vm.rulePackage = '';
		vm.showAddRuleTab = false;
		vm.showEditScreen = false;
		vm.ruleMasterId = 0;
	}

	function checkForInputParamaters(obj) {

		return obj.parameterName === vm.inputParameterArray[i].parameterName;
	}

	function checkForOutputParamaters(obj) {
		return obj.parameterName === vm.outputParameterArray[j].parameterName;
	}

	function checkForDescription(obj) {

		return obj.ruleDescription === vm.ruleDescription;
	}

	function checkForPackage(obj) {
		return obj.packageName === vm.ruleDescription;
	}
	activate();
});
