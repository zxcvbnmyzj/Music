using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.DAO
{
    public class Result
    {
        private int Code;

        private string Message;

        private object Data;

        public int code { get => Code; set => Code = value; }
        public string message { get => Message; set => Message = value; }
        public object data { get => Data; set => Data = value; }
    }
}
