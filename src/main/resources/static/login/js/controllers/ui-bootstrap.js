materialAdmin

    //====================================
    // ALERT
    //====================================

    .controller('AlertDemoCtrl', function ($scope) {
        $scope.alerts = [
            { type: 'info', msg: "Well done! You successfully read this important alert message." },
            { type: 'success', msg: "Well done! You successfully read this important alert message." },
            { type: 'warning', msg: "Warning! Better check yourself, you're not looking too good." },
            { type: 'danger', msg: "Oh snap! Change a few things up and try submitting again." }
        ];

        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
        };
    })

    
    //====================================
    // BUTTONS
    //====================================

    .controller('ButtonsDemoCtrl', function ($scope) {
        $scope.singleModel = 1;

        $scope.radioModel = 'Middle';

        $scope.checkModel = {
            left: false,
            middle: true,
            right: false
        };
    })

    
    //====================================
    // CAROUSEL
    //====================================

    .controller('CarouselDemoCtrl', function ($scope) {
        $scope.myInterval = 0;
        $scope.slides = [
            {
                img: 'c-1.jpg',
                title: 'First Slide Label',
                text: 'Some sample text goes here...'
            },
            {
                img: 'c-2.jpg',
                title: 'Second Slide Label',
                text: 'Some sample text goes here...'
            },
            {
                img: 'c-3.jpg'
            }
        ];

    })


    //====================================
    // CAROUSEL
    //====================================

    .controller('CollapseDemoCtrl', function ($scope) {
        $scope.isCollapsed = false;
    })


    //====================================
    // DROPDOWN
    //====================================

    .controller('DropdownDemoCtrl', function ($scope) {
        $scope.items = [
            { name: 'The first choice!', icon: 'home' },
            { name: 'And another choice', icon: 'account' },
            { name: 'But wait! A third!', icon: 'email' },
            { name: 'And fourth on here', icon: 'pin' }
        ];
    })

    
    //====================================
    // MODAL
    //====================================
    .controller('ModalDemoCtrl', function ($scope, $modal, $log) {

        $scope.modalContent = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.';
    
        //Create Modal
        function modalInstances(animation, size, backdrop, keyboard) {
            var modalInstance = $modal.open({
                animation: animation,
                templateUrl: 'myModalContent.html',
                controller: 'ModalInstanceCtrl',
                size: size,
                backdrop: backdrop,
                keyboard: keyboard,
                resolve: {
                    content: function () {
                        return $scope.modalContent;
                    }
                }
            
            });
        }
        
        //Custom Sizes
        $scope.open = function (size) {
            modalInstances(true, size, true, true)
        }
        
        //Without Animation
        $scope.openWithoutAnimation = function() {
            modalInstances(false, '', true, true)
        }
        
        //Prevent Outside Click
        $scope.openStatic = function () {
            modalInstances(true, '', 'static', true)
        };
    
        //Disable Keyboard
        $scope.openKeyboard = function () {
            modalInstances(true, '', true, false)
        };

    })

    // Please note that $modalInstance represents a modal window (instance) dependency.
    // It is not the same as the $modal service used above.

    .controller('ModalInstanceCtrl', function ($scope, $modalInstance, content) {

          $scope.modalContent = content;

          $scope.ok = function () {
            $modalInstance.close();
          };

          $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
          };
    })
    

    //====================================
    // PAGINATION
    //====================================

    .controller('PaginationDemoCtrl', function ($scope, $log) {
        $scope.totalItems = 64;
        $scope.currentPage = 4;

        $scope.setPage = function (pageNo) {
            $scope.currentPage = pageNo;
        };

        $scope.maxSize = 5;
        $scope.bigTotalItems = 175;
        $scope.bigCurrentPage = 1;
    })


    //====================================
    // POPOVER
    //====================================

    .controller('PopoverDemoCtrl', function ($scope) {
        $scope.dynamicPopover = {
            templateUrl: 'myPopoverTemplate.html',
        };
    })

    //====================================
    // PROGRESSBAR
    //====================================

    .controller('ProgressDemoCtrl', function ($scope) {
        $scope.max = 200;

        $scope.random = function() {
            var value = Math.floor((Math.random() * 100) + 1);
            var type;

            if (value < 25) {
                type = 'success';
            } 
            else if (value < 50) {
                  type = 'info';
            } 
            else if (value < 75) {
                  type = 'warning';
            } 
            else {
                  type = 'danger';
            }

            $scope.showWarning = (type === 'danger' || type === 'warning');

            $scope.dynamic = value;
            $scope.type = type;
        };

        $scope.random();

        $scope.randomStacked = function() {
            $scope.stacked = [];
            var types = ['success', 'info', 'warning', 'danger'];

            for (var i = 0, n = Math.floor((Math.random() * 4) + 1); i < n; i++) {
                var index = Math.floor((Math.random() * 4));
                $scope.stacked.push({
                    value: Math.floor((Math.random() * 30) + 1),
                    type: types[index]
                });
            }
        };
    
        $scope.randomStacked();
    })


    //====================================
    // TABS
    //====================================

    .controller('TabsDemoCtrl', function ($scope, $window) {
        $scope.tabs = [
            { 
                title:'Home', 
                content:'In hac habitasse platea dictumst. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Nam eget dui. In ac felis quis tortor malesuada pretium. Phasellus consectetuer vestibulum elit. Duis lobortis massa imperdiet quam. Pellentesque commodo eros a enim. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Phasellus a est. Pellentesque commodo eros a enim. Cras ultricies mi eu turpis hendrerit fringilla. Donec mollis hendrerit risus. Vestibulum turpis sem, aliquet eget, lobortis pellentesque, rutrum eu, nisl. Praesent egestas neque eu enim. In hac habitasse platea dictumst.' 
            },
            { 
                title:'Profile', 
                content:'Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nulla sit amet est. Praesent ac massa at ligula laoreet iaculis. Vivamus aliquet elit ac nisl. Nulla porta dolor. Cras dapibus. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus.', 
            },
            { 
                title:'Messages', 
                content:'Etiam rhoncus. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Cras id dui. Curabitur turpis. Etiam ut purus mattis mauris sodales aliquam. Aenean viverra rhoncus pede. Nulla sit amet est. Donec mi odio, faucibus at, scelerisque quis, convallis in, nisi. Praesent ac sem eget est egestas volutpat. Cras varius. Morbi mollis tellus ac sapien. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nam ipsum risus, rutrum vitae, vestibulum eu, molestie vel, lacus. Fusce vel dui.Morbi mattis ullamcorper velit. Etiam rhoncus. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Cras id dui. Curabitur turpis. Etiam ut purus mattis mauris sodales aliquam. Aenean viverra rhoncus pede. Nulla sit amet est. Donec mi odio, faucibus at, scelerisque quis, convallis in, nisi. Praesent ac sem eget est egestas volutpat. Cras varius. Morbi mollis tellus ac sapien. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nam ipsum risus, rutrum vitae, vestibulum eu, molestie vel, lacus. Fusce vel dui.', 
            },
            { 
                title:'Settings', 
                content:'Praesent turpis. Phasellus magna. Fusce vulputate eleifend sapien. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis.', 
            }
        ];

    })

    
    //====================================
    // TOOLTIPS
    //====================================

    .controller('TooltipDemoCtrl', function ($scope, $sce) {
          $scope.htmlTooltip = $sce.trustAsHtml('I\'ve been made <b>bold</b>!');
    })

    
    //====================================
    // DATE PICKER
    //====================================
    .controller('DatepickerDemoCtrl', function ($scope) {
        $scope.today = function() {
            $scope.dt = new Date();
        };
        $scope.today();


        $scope.toggleMin = function() {
            $scope.minDate = $scope.minDate ? null : new Date();
        };
        $scope.toggleMin();

        $scope.open = function($event, opened) {
            $event.preventDefault();
            $event.stopPropagation();

            $scope[opened] = true;
        };

        $scope.dateOptions = {
            formatYear: 'yy',
            startingDay: 1
        };

        $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];
    })  



    //====================================
    // TYPEAHEAD
    //====================================
    .controller('TypeaheadCtrl', function($scope, $http) {

        $scope.selected = undefined;
        $scope.states = [
            'Alabama', 
            'Alaska', 
            'Arizona', 
            'Arkansas', 
            'California', 
            'Colorado', 
            'Connecticut', 
            'Delaware', 
            'Florida', 
            'Georgia', 
            'Hawaii', 
            'Idaho', 
            'Illinois', 
            'Indiana', 
            'Iowa', 
            'Kansas', 
            'Kentucky',                       
            'Louisiana', 
            'Maine', 
            'Maryland',
            'Massachusetts',
            'Michigan',
            'Minnesota', 
            'Mississippi',
            'Missouri',
            'Montana', 
            'Nebraska', 
            'Nevada',
            'New Hampshire',
            'New Jersey',
            'New Mexico', 
            'New York', 
            'North Dakota', 
            'North Carolina',
            'Ohio', 
            'Oklahoma',
            'Oregon', 
            'Pennsylvania',
            'Rhode Island', 
            'South Carolina',
            'South Dakota',
            'Tennessee', 
            'Texas', 
            'Utah',
            'Vermont',
            'Virginia', 
            'Washington',
            'West Virginia',
            'Wisconsin',
            'Wyoming'
        ];
    
        // Any function returning a promise object can be used to load values asynchronously
        $scope.getLocation = function(val) {
            return $http.get('//maps.googleapis.com/maps/api/geocode/json', {
                params: {
                    address: val,
                    sensor: false
                }
            }).then(function(response){
                return response.data.results.map(function(item){
                    return item.formatted_address;
                });
            });
        }
    }) 