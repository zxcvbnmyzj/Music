using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.DAO
{
    public static class URL
    {
        public static readonly string BASIC_URL = "http://127.0.0.1:6060/yohane/music";

        private static string GET_ALL_MUSIC_BASIC = "/getAll";

        private readonly static string ADD_MUSIC_LIST_BASIC = "/addMusicList";

        private readonly static string SELECT_MUSIC_BASIC = "/selectMusic";

        public static string GET_ALL_MUSIC { get => BASIC_URL + GET_ALL_MUSIC_BASIC; }

        public static string ADD_MUSIC_LIST => BASIC_URL + ADD_MUSIC_LIST_BASIC;

        public static string SELECT_MUSIC(string name, string singer)
        {
            return BASIC_URL + SELECT_MUSIC_BASIC + $"?name={name}&singer={singer}";
        }

    }
}
