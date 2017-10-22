package com.dhirajkumarcoder.android.tinderpets.Model.UiModels;

/**
 * Created by Abhinav on 22/10/17.
 */

public class IndividualPhotoUrls
{
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

    public class Data
    {
        private String id;

        private Images[] images;

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public Images[] getImages ()
        {
            return images;
        }

        public void setImages (Images[] images)
        {
            this.images = images;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", images = "+images+"]";
        }
    }

    public class Images
    {
        private String height;

        private String source;

        private String width;

        public String getHeight ()
        {
            return height;
        }

        public void setHeight (String height)
        {
            this.height = height;
        }

        public String getSource ()
        {
            return source;
        }

        public void setSource (String source)
        {
            this.source = source;
        }

        public String getWidth ()
        {
            return width;
        }

        public void setWidth (String width)
        {
            this.width = width;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [height = "+height+", source = "+source+", width = "+width+"]";
        }
    }

}


