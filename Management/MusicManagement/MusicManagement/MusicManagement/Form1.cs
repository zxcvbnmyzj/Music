using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Service;

namespace MusicManagement
{
    public partial class Form1 : Form
    {
        MainService main = new MainService();

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Resize(object sender, EventArgs e)
        {
           
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                DataViewLoad();
            }catch(Exception err)
            {
                Console.WriteLine(err.Message);
                MessageBox.Show("提示","服务器错误!请稍后重试",MessageBoxButtons.OK, MessageBoxIcon.Error);
                System.Environment.Exit(0);
            }
            
        }

        private void DataViewLoad()
        {
            MusicDataGrid.Dock = DockStyle.Fill;
            MusicDataGrid.ReadOnly = true;
            MusicDataGrid.MultiSelect = false;
            MusicDataGrid.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            MusicDataGrid.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
            MusicDataGrid.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            MusicDataGrid.DataSource = main.getDataBinding();
        }

        private void menu_Add_Click(object sender, EventArgs e)
        {
            AddMusicForm addMusicForm = new AddMusicForm();
            addMusicForm.ShowDialog();
        }
    }
}
