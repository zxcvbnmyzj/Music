using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using Service;

namespace MusicManagement
{
    public partial class AddMusicForm : Form
    {
        AddService addService;

        public AddMusicForm()
        {
            InitializeComponent();
            Control.CheckForIllegalCrossThreadCalls = false;
            addService = new AddService(txt_MusicName, txt_Singer);
        }

        private void AddMusicForm_Load(object sender, EventArgs e)
        {
            ViewLoad();
        }

        private void ViewLoad()
        {
            WaitMusicList_View.ReadOnly = true;
            WaitMusicList_View.MultiSelect = false;
            WaitMusicList_View.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            WaitMusicList_View.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
            WaitMusicList_View.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
        }

        private void bt_submit_list_Click(object sender, EventArgs e)
        {
            Thread bar = new Thread(SubDataLoad);
            bar.Start();
        }

        private void bt_AddList_Click(object sender, EventArgs e)
        {
            string singer = txt_Singer.Text;
            string name = txt_MusicName.Text;
            WaitMusicList_View.DataSource = addService.addMusicList(singer, name);
            WaitMusicList_View.Columns.RemoveAt(0);
        }

        private void SubDataLoad()
        {
            //if (!addService.addMusic((BindingList<Service.DAO.VO.Music>)WaitMusicList_View.DataSource))
            //    return;
            Add_proBar.Step = 1;
            Graphics g = this.Add_proBar.CreateGraphics();
            lockControl();
            for (int i = 0; i < 100; i++)
            {
                Add_proBar.PerformStep();
                string str = Math.Round((100 * i / 100.0), 2).ToString("#0.00") + "%";
                Font font = new Font("Time new Roman", (float)10, FontStyle.Regular);
                PointF pt = new PointF(this.Add_proBar.Width / 2 - 17, this.Add_proBar.Height / 2 - 7);
                g.DrawString(str, font, Brushes.Black, pt);
                Thread.Sleep(30);
            }
            UnLocakControl();
            MessageBox.Show("完成!", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
            this.Close();
        }

        private void lockControl()
        {
            txt_MusicName.Enabled = false;
            txt_Singer.Enabled = false;
            bt_AddList.Enabled = false;
            bt_submit_list.Enabled = false;
        }
        
        private void UnLocakControl()
        {
            txt_MusicName.Enabled = true;
            txt_Singer.Enabled = true;
            bt_AddList.Enabled = true;
            bt_submit_list.Enabled = true;
        }

        private void backgroundWorker1_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
        {
            MessageBox.Show("上传完成", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void backgroundWorker1_DoWork(object sender, DoWorkEventArgs e)
        {

        }

        private void bt_selectMp_Click(object sender, EventArgs e)
        {
            OpenFileDialog op = new OpenFileDialog();
            op.Multiselect = false;
            op.Title = "选择音频";
            op.Filter = "音频文件(*.mp3)|*.mp3";
            op.RestoreDirectory = false;
            if (op.ShowDialog() == DialogResult.OK)
            {
                string path = op.FileName;
                MessageBox.Show(path);
            }  
        }
    }
}
