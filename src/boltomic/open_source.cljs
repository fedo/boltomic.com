(ns boltomic.open-source)


(defn open-source-component
  []
  [:section.section--center.mdl-color--grey-800.bltmc-section-open-source
   [:div.mdl-grid.mdl-grid--max-width
    [:div.mdl-cell.mdl-cell--4-col.mdl-typography--text-center
     [:img {:src (str "images/logos/github-white.png") :style
                 {:max-width "100%" :max-height "200px"}}]]
    [:div.mdl-cell.mdl-cell--8-col.mdl-color-text--white
     [:div.bltmc-section-title "Talk is cheap." [:br] "Show me the code."]
     [:div
      [:p "This website is built using " [:a "Reagent"] ", a " [:a "ClojureScript"] " interface to "[:a "Facebook's React"]". "]
      [:p "For the look and feel I use " [:a "Material Design Lite"] " and custom styles written in SCSS. "]
      [:p "In order to automate tasks the project is configured with " [:a "Leiningen"] ",
      with a little help from " [:a "Gulp"] " which provides a large variety of plugins."]
      [:p [:a "CirleCI"] " handles continuous integration and automatic deployment to " [:a "Amazon S3"]". "]
      [:p "You can find the source code of this project in " [:a "GitHub"] ". If find a bug or you have
      an idea on how to improve it please create an "[:a "issue"] " or send me an " [:a "email"] ". I'm really
      keen on discussing about different methodologies and technologies."]]]]])