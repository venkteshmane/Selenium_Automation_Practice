




    


    /**
 * Object holds current system settings information.
 */
window.SystemSettings = {};

/**
 * Symbol for separating decimal and fraction parts of a number.
 */
SystemSettings.decimalSeparator = ".";

/**
 * Symbol for grouping digits in a number.
 */
SystemSettings.digitGroupingSymbol = "";

SystemSettings.weekStartDay = 2;

SystemSettings.defaultWorkSchedule = [0, 480, 480, 480, 480, 480, 0];

/**
* Singular form of user group naming
 */
SystemSettings.userGroupNamingSingular = "Department";

/**
 * Plural form of user group naming
 */
SystemSettings.userGroupNamingPlural = "Departments";
/**
 * Singular form of first hierarchy level naming
 */
SystemSettings.firstLevelNamingSingular = "Customer";

/**
 * Plural form of first hierarchy level naming
 */
SystemSettings.firstLevelNamingPlural = "Customers";

/**
 * Singular form of second hierarchy level naming
 */
SystemSettings.secondLevelNamingSingular = "Project";

/**
 * Plural form of second hierarchy level naming
 */
SystemSettings.secondLevelNamingPlural = "Projects";

/**
 * Singular form of second hierarchy level naming
 */
SystemSettings.thirdLevelNamingSingular = "Task";

/**
 * Plural form of second hierarchy level naming
 */
SystemSettings.thirdLevelNamingPlural = "Tasks";

/**
 * Overtime message
 */
SystemSettings.overtimeNaming = "overtime";

//TODO may be move it to another class
SystemSettings.usersWithoutGroupId = -1;

SystemSettings.dateFormat = "MMM dd, yyyy";


SystemSettings.defaultTimeFormatForHTMLReports = 'TIME';

SystemSettings.showPTOInHours = false;

SystemSettings.showSickInHours = false;

SystemSettings.roundPTOBalanceOnUserlist = false;

SystemSettings.roundSickBalanceOnUserlist = false;

SystemSettings.CUSTOM_VALUE_STRING = "-custom_value-";

SystemSettings.currencySign = "$";

SystemSettings.ptoBalanceCalculationEnabled = true;

SystemSettings.apPtoBalanceCalculationEnabled = true;

SystemSettings.apSickBalanceCalculationEnabled = false;

SystemSettings.apUGREnabled = true;

SystemSettings.apTZGEnabled = false;

SystemSettings.defaultOvertimeLevel = 0;

/**
 * Symbol for separating csv fields.
 */
SystemSettings.csvSeparator = ",";

SystemSettings.csvMultilanguage = false;

//{ruleIds: ["str", "str"], minimalLength: number}
SystemSettings.passwordSettings = {"ruleIds":["password_validation.length"],"minimalLength":6};