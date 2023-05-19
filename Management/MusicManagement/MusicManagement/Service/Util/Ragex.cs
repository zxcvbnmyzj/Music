using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Service.Util
{
    public static class Ragex
    {

        public static bool isEmpty(string str)
        {
            str.Trim();
            return str == null || str.Equals("");
        }

        /// <summary>
        /// true:Have
        /// </summary>
        /// <param name="str"></param>
        /// <returns></returns>
        public static bool isSpecial(string str)
        {
            Regex regex = new Regex("[ \\[ \\] \\^ \\-_*×――(^)$%~!＠@＃#$…&%￥—+=<>《》!！??？:：•`·、。，；,.;/\'\"{}（）‘’“”-]");
            return regex.IsMatch(str);
        }

    }
}
