import React, { useState } from "react";
import "./App.css";

function App() {
  const moodData = {
    happy: {
      quotes: ["Smile, life is beautiful!", "Happiness is a choice!"],
      images: ["/images/happy1.jpg", "/images/happy2.jpg"]
    },
    sad: {
      quotes: ["This too shall pass.", "Every storm ends."],
      images: ["/images/sad1.jpg", "/images/sad2.jpg"]
    },
    motivated: {
      quotes: ["Keep going!", "You can do it!"],
      images: ["/images/motivated1.jpg", "/images/motivated2.jpg"]
    },
    relaxed: {
      quotes: ["Take it easy.", "Breathe and relax."],
      images: ["/images/relaxed1.jpg", "/images/relaxed2.jpg"]
    }
  };

  const [selectedMood, setSelectedMood] = useState("");
  const [currentIndex, setCurrentIndex] = useState(0);

  const handleNext = () => {
    if (!selectedMood) return;
    setCurrentIndex((prev) => (prev + 1) % moodData[selectedMood].quotes.length);
  };

  return (
    <div className="App">
      <h1>Mood-Based Wallpaper & Quote App</h1>

      {/* Mood Buttons */}
      <div>
        {Object.keys(moodData).map((mood) => (
          <button
            key={mood}
            onClick={() => {
              setSelectedMood(mood);
              setCurrentIndex(0);
            }}
          >
            {mood.charAt(0).toUpperCase() + mood.slice(1)}
          </button>
        ))}
      </div>

      {/* Display */}
      {selectedMood && (
        <div>
          <img
            src={moodData[selectedMood].images[currentIndex]}
            alt={selectedMood}
            style={{ width: "300px", height: "200px", marginTop: "20px" }}
          />
          <p>{moodData[selectedMood].quotes[currentIndex]}</p>
          <button onClick={handleNext}>Next</button>
        </div>
      )}
    </div>
  );
}

export default App;
