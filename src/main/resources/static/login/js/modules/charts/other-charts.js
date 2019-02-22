materialAdmin

    // =========================================================================
    // SPARKLINE CHARTS
    // =========================================================================
    
    //Bar Chart

    .directive('sparklineBar', function(){

        return {
            restrict: 'A',
            link: function(scope, element) {
                function sparkLineBar(selector, values, height, barWidth, barColor, barSpacing) {
                   $(selector).sparkline(values, {
                        type: 'bar',
                        height: height,
                        barWidth: barWidth,
                        barColor: barColor,
                        barSpacing: barSpacing
                   });
                }
                
                sparkLineBar('.stats-bar', [6,4,8,6,5,6,7,8,3,5,9,5,8,4,3,6,8], '45px', 3, '#fff', 2);
                sparkLineBar('.stats-bar-2', [4,7,6,2,5,3,8,6,6,4,8,6,5,8,2,4,6], '45px', 3, '#fff', 2);
            }
        }
    })
    

    //Line Chart

    .directive('sparklineLine', function(){

        return {
            restrict: 'A',
            link: function(scope, element) {
                function sparkLineLine(selector, values, width, height, lineColor, fillColor, lineWidth, maxSpotColor, minSpotColor, spotColor, spotRadius, hSpotColor, hLineColor) {
                    $(selector).sparkline(values, {
                        type: 'line',
                        width: width,
                        height: height,
                        lineColor: lineColor,
                        fillColor: fillColor,
                        lineWidth: lineWidth,
                        maxSpotColor: maxSpotColor,
                        minSpotColor: minSpotColor,
                        spotColor: spotColor,
                        spotRadius: spotRadius,
                        highlightSpotColor: hSpotColor,
                        highlightLineColor: hLineColor
                    });
                }

                sparkLineLine('.stats-line', [9,4,6,5,6,4,5,7,9,3,6,5], 85, 45, '#fff', 'rgba(0,0,0,0)', 1.25, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 3, '#fff', 'rgba(255,255,255,0.4)');
                sparkLineLine('.stats-line-2', [5,6,3,9,7,5,4,6,5,6,4,9], 85, 45, '#fff', 'rgba(0,0,0,0)', 1.25, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 3, '#fff', 'rgba(255,255,255,0.4)');
                sparkLineLine('.dash-widget-visits', [9,4,6,5,6,4,5,7,9,3,6,5], '100%', '95px', 'rgba(255,255,255,0.7)', 'rgba(0,0,0,0)', 2, 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.4)', 5, 'rgba(255,255,255,0.4)', '#fff');

            }
        }
    })

    
    // Pie Charts

    .directive('sparklinePie', function(){
        return {
            restrict: 'A',
            link: function(scope, element, attrs) {
                function sparklinePie(select, values, width, height, sliceColors) {
                    $(select).sparkline(values, {
                        type: 'pie',
                        width: width,
                        height: height,
                        sliceColors: sliceColors,
                        offset: 0,
                        borderWidth: 0
                    });
                }   
                
                if ($('.stats-pie')[0]) {
                    sparklinePie('.stats-pie', [20, 35, 30, 5], 45, 45, ['#fff', 'rgba(255,255,255,0.7)', 'rgba(255,255,255,0.4)', 'rgba(255,255,255,0.2)']);
                }
            }
        }
    })



    // =========================================================================
    // EASY PIE CHARTS
    // =========================================================================
    
    .directive('easypieChart', function(){
        return {
            restrict: 'A',
            link: function(scope, element) {
                function easyPieChart(selector, trackColor, scaleColor, barColor, lineWidth, lineCap, size) {
                    $(selector).easyPieChart({
                        trackColor: trackColor,
                        scaleColor: scaleColor,
                        barColor: barColor,
                        lineWidth: lineWidth,
                        lineCap: lineCap,
                        size: size
                    });
                }

                easyPieChart('.main-pie', 'rgba(255,255,255,0.2)', 'rgba(255,255,255,0.5)', 'rgba(255,255,255,0.7)', 7, 'butt', 148);
                easyPieChart('.sub-pie-1', '#eee', '#ccc', '#2196F3', 4, 'butt', 95);
                easyPieChart('.sub-pie-2', '#eee', '#ccc', '#FFC107', 4, 'butt', 95);
            }
        }
    })