package com.dhirajkumarcoder.android.tinderpets.Model.UiModels;

/**
 * Created by Abhinav on 22/10/17.
 */

public class UserAlbums {
    private Data[] data;

    private Paging paging;

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    public Paging getPaging ()
    {
        return paging;
    }

    public void setPaging (Paging paging)
    {
        this.paging = paging;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", paging = "+paging+"]";
    }

    public class Data
    {
        private String id;

        private String name;

        private String created_time;

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getCreated_time ()
        {
            return created_time;
        }

        public void setCreated_time (String created_time)
        {
            this.created_time = created_time;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", name = "+name+", created_time = "+created_time+"]";
        }
    }

    public class Paging
    {
        private String next;

        private Cursors cursors;

        public String getNext ()
        {
            return next;
        }

        public void setNext (String next)
        {
            this.next = next;
        }

        public Cursors getCursors ()
        {
            return cursors;
        }

        public void setCursors (Cursors cursors)
        {
            this.cursors = cursors;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [next = "+next+", cursors = "+cursors+"]";
        }
    }

    public class Cursors
    {
        private String after;

        private String before;

        public String getAfter ()
        {
            return after;
        }

        public void setAfter (String after)
        {
            this.after = after;
        }

        public String getBefore ()
        {
            return before;
        }

        public void setBefore (String before)
        {
            this.before = before;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [after = "+after+", before = "+before+"]";
        }
    }

}
