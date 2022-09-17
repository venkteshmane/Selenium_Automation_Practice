

Date.dayNames = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
Date.dayNamesShort = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
Date.dayNamesShortCapital = ["SUN","MON","TUE","WED","THU","FRI","SAT"];
Date.dayNamesAbbr = ["S","M","T","W","T","F","S"];
Date.getShortDayName = function (i) { return Date.dayNamesShort[i]; };
Date.getDayNameAbbr = function (i) { return Date.dayNamesAbbr[i]; };
Date.monthNames = ["January","February","March","April","May","June","July","August","September","October","November","December"];
Date.monthNamesShort = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
Date.getShortMonthName = function (i) { return Date.monthNamesShort[i]; };
Date.monthNumbers = {
Jan: 0,
Feb: 1,
Mar: 2,
Apr: 3,
May: 4,
Jun: 5,
Jul: 6,
Aug: 7,
Sep: 8,
Oct: 9,
Nov: 10,
Dec: 11
};

Date.JSON_DATE_FORMAT = "Y-m-d";
Date.JSON_TIME_FORMAT = "Y-m-d H:i:s.u O";
Date.JSON_TIME_FORMAT_WITHOUT_TIME_ZONE = "Y-m-d H:i:s.u";

Date.prototype.toJSONString = function()
{
    return this.toJSON();
};

Date.prototype.toJSON = function()
{
    return this.format( Date.JSON_DATE_FORMAT );
};

Date.parseJSONDate = function( dateStr )
{
    return Date.parseDate(dateStr.substring(0, 10), Date.JSON_DATE_FORMAT, true ).truncateTime();
};

Date.parseJSONTime = function( timeStr )
{
    return Date.parseDate(timeStr, Date.JSON_TIME_FORMAT, true );
};

Date.parseJSONTimeWithoutTimeZone = function( timeStr )
{
    return Date.parseDate(timeStr.substring(0, timeStr.length - 6), Date.JSON_TIME_FORMAT_WITHOUT_TIME_ZONE, true);
};

String.prototype.parseJSONDate = function()
{
    return Date.parseJSONDate(this);
};

String.prototype.parseJSONTime = function()
{
    return Date.parseJSONTime(this);
};

Date.prototype.truncateTime = function(clone)
{
    if (clone)
        return this.clone().truncateTime();

    // clear time
    this.setHours(12);
    this.setMinutes(0);
    this.setSeconds(0);
    this.setMilliseconds(0);

    return this;
};

Date.create = function( y, m, d, h, mi, s, ms )
{
    if( !h ) h = 12;
    if( !mi ) mi = 0;
    if( !s ) s = 0;
    if( !ms ) ms = 0;
    return new Date(y, m, d, h, mi, s, ms);
};

Date.prototype.isSameDate = function( d )
{
    return this.getDate() == d.getDate() &&
           this.getMonth() == d.getMonth() &&
           this.getFullYear() == d.getFullYear();
};

Date.prototype.offsetInDaysFrom = function(d)
{
    var date1 = Date.UTC( d.getFullYear(), d.getMonth(), d.getDate() );
    var date2 = Date.UTC( this.getFullYear(), this.getMonth(), this.getDate() );
    var ms = date2 - date1;
    return Math.floor( ms / 1000/60/60/24 ); //floor should be unnecessary, but just in case
};

Date.max = function( d1, d2 )
{
    return d1.getTime() > d2.getTime() ? d1 : d2;
};

Date.min = function( d1, d2 )
{
    return d1.getTime() > d2.getTime() ? d2 : d1;
};

Date.prototype.nextDay = function ()
{
    return Date.create( this.getFullYear(), this.getMonth(), this.getDate() + 1);
};

Date.prototype.prevDay = function ()
{
    return Date.create( this.getFullYear(), this.getMonth(), this.getDate() - 1);
};

Date.prototype.getNDaysBefore = function (n)
{
    return Date.create( this.getFullYear(), this.getMonth(), this.getDate() - n);
};

Date.prototype.getNDaysAfter = function (n)
{
    return Date.create( this.getFullYear(), this.getMonth(), this.getDate() + n);
};

Date.prototype.getWeekStartDate = function ( weekStartDay )
{
    return this.getNDaysBefore( (this.getDay() - weekStartDay + 7) % 7 );
};

/**
 * Converts Smart date format (see DateFormat class) to ExtJS date
 * format (see Date.parseDate).
 * <br/>
 * The implementation is extremely trivial and can cause rather weird
 * results.
 *
 * @param smartDateFormat
 */
Date.convertSmartToExtDateFormat = function( smartDateFormat )
{
    var extDateFormat = smartDateFormat;
    extDateFormat = extDateFormat.replace(/MMMM/, "F");
    extDateFormat = extDateFormat.replace(/MMM/, "M");
    extDateFormat = extDateFormat.replace(/MM/, "m");
    extDateFormat = extDateFormat.replace(/dd/, "d");
    extDateFormat = extDateFormat.replace(/yyyy/, "Y");
    extDateFormat = extDateFormat.replace(/yy/, "y");
    return extDateFormat;
};
